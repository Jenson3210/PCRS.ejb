package colruyt.pcrs.views;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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


@Named
@ViewScoped
public class AdminSurveyDefinitionView implements Serializable{
	
	
	private static final long serialVersionUID = 5L;
	
	@EJB
	private IUserFacade userFacade;
	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;
	
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
		//	private UserBo addedUserBo;
		manipulatedSurveyDefinitionBo = surveyDefinitionFacade.save(manipulatedSurveyDefinitionBo);	
		manipulatedUserBo.getPrivileges().add(new SurveyDefinitionResponsibleUserPrivilegeBo(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, true, manipulatedSurveyDefinitionBo));
		manipulatedUserBo = userFacade.save(manipulatedUserBo);
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
		surveyDefinitions.remove(manipulatedSurveyDefinitionBo);
		SurveyDefinitionResponsibleUserPrivilegeBo sdrup = null;
		for (UserPrivilegeBo up : manipulatedUserBo.getPrivileges()) {
			if (up.getPrivilegeType().equals(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE) 
					&& ((SurveyDefinitionResponsibleUserPrivilegeBo)up).getSurveyDefinition().getId() 
						== manipulatedSurveyDefinitionBo.getId()) {
				sdrup = (SurveyDefinitionResponsibleUserPrivilegeBo) up;
			}
		}
		manipulatedUserBo.getPrivileges().remove(sdrup);
		userFacade.save(manipulatedUserBo);
		surveyDefinitionFacade.delete(manipulatedSurveyDefinitionBo);
	}
	
	/**
	 * modifies the survey definition and sets a new name and/or new responsible
	 */
	public void editSurveyDefinition() {
		SurveyDefinitionResponsibleUserPrivilegeBo sdrup = null;
		for (UserPrivilegeBo up : manipulatedUserBo.getPrivileges()) {
			if (up.getPrivilegeType().equals(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE) 
					&& ((SurveyDefinitionResponsibleUserPrivilegeBo)up).getSurveyDefinition().getId() 
						== manipulatedSurveyDefinitionBo.getId()) {
				sdrup = (SurveyDefinitionResponsibleUserPrivilegeBo) up;
			}
		}
		manipulatedUserBo.getPrivileges().remove(sdrup);
		userFacade.save(manipulatedUserBo);
		//GIVE THE PRIVILEGE TO THE USER
		manipulatedUserBo.getPrivileges().add(new SurveyDefinitionResponsibleUserPrivilegeBo(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, true, manipulatedSurveyDefinitionBo));
		manipulatedUserBo = userFacade.save(manipulatedUserBo);
		//UPDATE THE LIST
		for (SurveyDefinitionBo bo : surveyDefinitions.keySet()) {
			if (bo.getId() == manipulatedSurveyDefinitionBo.getId()) {
				bo.setName(manipulatedSurveyDefinitionBo.getName());
				surveyDefinitions.put(bo, manipulatedUserBo);
			}
		}
		surveyDefinitionFacade.save(manipulatedSurveyDefinitionBo);
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

