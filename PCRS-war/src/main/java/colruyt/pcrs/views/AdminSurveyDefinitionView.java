package colruyt.pcrs.views;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyDefinitionResponsibleUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.privilege.IUserPrivilegeFacade;


@Named
@ViewScoped
public class AdminSurveyDefinitionView implements Serializable{
	
	
	private static final long serialVersionUID = 5L;
	
	@EJB
	private IUserFacade userFacade;
	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;
	@EJB
	private IUserPrivilegeFacade userPrivilegeFacade;
	
	private Map<SurveyDefinitionBo, UserBo> surveyDefinitions = new HashMap<>();
	
	private SurveyDefinitionBo manipulatedSurveyDefinitionBo;
	private UserBo manipulatedUserBo;

	
	/**
	 * mandatory empty constructor
	 */
	public AdminSurveyDefinitionView() {  
	}
	
	
	/**
	 * setup of the screen, loading the needed data
	 */
	@PostConstruct
	public void setup() {
		List<SurveyDefinitionBo> sd = surveyDefinitionFacade.getAll();
		for (SurveyDefinitionBo bo : sd) {
			surveyDefinitions.put(bo, surveyDefinitionFacade.getResponsible(bo));
		}
	}
	
	
	public void newSurveyDefinition() {
		manipulatedSurveyDefinitionBo = new SurveyDefinitionBo();
		manipulatedUserBo = new UserBo();
	}
	

	public void addSurveyDefinition() {
		//SAVE THE SURVEYDEFINITION
		manipulatedSurveyDefinitionBo = surveyDefinitionFacade.save(manipulatedSurveyDefinitionBo);	
		//MAKE SOMEONE RESPONSIBLE
		manipulatedUserBo = userPrivilegeFacade.grantUserPrivilegeToUser(userFacade.get(manipulatedUserBo), new SurveyDefinitionResponsibleUserPrivilegeBo(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, true, manipulatedSurveyDefinitionBo));
		//ADD THE SURVEY TO THE SCREEN
		surveyDefinitions.put(manipulatedSurveyDefinitionBo, manipulatedUserBo);
	}
	
	/**
	 * method used for completing the autocomplete input field in the dialog when adding 
	 * a survey definition  
	 * @param query: text typed in the input field
	 * @return: List of users for which their short name matches the query parameter
	 */
	public List<UserBo> completeShortName(String query){
		return userFacade.getUsersByShortName("%" + query + "%");
	}
	
	
	/**
	 * deletes the survey definition from the List and from the DB
	 */
	public void deleteSurveyDefinition(){
		//REMOVE FROM LOCAL LIST
		surveyDefinitions.remove(manipulatedSurveyDefinitionBo);
		//REMOVE THE RESPONSIBLES PRIVILEGE
		userPrivilegeFacade.revokeUserPrivilegeTypeFromUser(userFacade.get(manipulatedUserBo), PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, manipulatedSurveyDefinitionBo);
		//DELETE THE SURVEYDEFINITION
		surveyDefinitionFacade.delete(manipulatedSurveyDefinitionBo);
	}
	
	/**
	 * modifies the survey definition and sets a new name and/or new responsible
	 */
	public void editSurveyDefinition() {
		//REMOVE THE CURRENT RESPONSIBLES PRIVILEGE
		userPrivilegeFacade.revokeUserPrivilegeTypeFromUser(surveyDefinitionFacade.getResponsible(manipulatedSurveyDefinitionBo), PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, manipulatedSurveyDefinitionBo);
		//GIVE THE PRIVILEGE TO THE USER
		manipulatedUserBo = userPrivilegeFacade.grantUserPrivilegeToUser(userFacade.get(manipulatedUserBo), new SurveyDefinitionResponsibleUserPrivilegeBo(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, true, manipulatedSurveyDefinitionBo));
		//UPDATE THE LIST
		for (SurveyDefinitionBo bo : surveyDefinitions.keySet()) {
			if (bo.getId() == manipulatedSurveyDefinitionBo.getId()) {
				bo.setName(manipulatedSurveyDefinitionBo.getName());
				surveyDefinitions.put(bo, manipulatedUserBo);
			}
		}
		//UPDATE THE DATABASE TESTEN NOG OF WEL NODIG?
		//surveyDefinitionFacade.save(manipulatedSurveyDefinitionBo);
	}
	
	
	/*
	 *  Getters and Setters
	 */
	
	public Map<SurveyDefinitionBo, UserBo> getSurveyDefinitions() {
		return this.surveyDefinitions;
	}

	public void setSurveyDefinitions(Map<SurveyDefinitionBo, UserBo> surveyDefinitions) {
		this.surveyDefinitions = surveyDefinitions;
	}

	
	public SurveyDefinitionBo getManipulatedSurveyDefinitionBo() {
		return manipulatedSurveyDefinitionBo;
	}


	public void setManipulatedSurveyDefinitionBo(SurveyDefinitionBo manipulatedSurveyDefinition) {
		this.manipulatedSurveyDefinitionBo = manipulatedSurveyDefinition;
	}


	public UserBo getManipulatedUserBo() {
		return manipulatedUserBo;
	}


	public void setManipulatedUserBo(UserBo manipulatedUser) {
		this.manipulatedUserBo = manipulatedUser;
	}
		
}

