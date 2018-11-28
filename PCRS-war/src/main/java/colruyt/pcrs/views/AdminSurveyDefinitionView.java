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
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
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
	
	private SurveyDefinitionBo addedSurveyDefinitionBo;
	private UserBo addedUserBo;
	
	private Entry<SurveyDefinitionBo, UserBo> manipulatedRow;

	
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
		addedSurveyDefinitionBo = new SurveyDefinitionBo();
		addedUserBo = new UserBo();
	}
	

	public void addSurveyDefinition() {
		addedSurveyDefinitionBo = surveyDefinitionFacade.save(addedSurveyDefinitionBo);	
		addedUserBo.getPrivileges().add(new SurveyDefinitionResponsibleUserPrivilegeBo(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, true, addedSurveyDefinitionBo));
		addedUserBo = userFacade.save(addedUserBo);
		surveyDefinitions.put(addedSurveyDefinitionBo, addedUserBo);
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
		surveyDefinitions.remove(manipulatedRow.getKey());
		UserBo user = manipulatedRow.getValue();
		SurveyDefinitionResponsibleUserPrivilegeBo sdrup = null;
		for (UserPrivilegeBo up : user.getPrivileges()) {
			if (up.getPrivilegeType().equals(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE) 
					&& ((SurveyDefinitionResponsibleUserPrivilegeBo)up).getSurveyDefinition().getId() 
						== manipulatedRow.getKey().getId()) {
				sdrup = (SurveyDefinitionResponsibleUserPrivilegeBo) up;
			}
		}
		user.getPrivileges().remove(sdrup);
		userFacade.save(user);
		surveyDefinitionFacade.delete(manipulatedRow.getKey());
	}
	
	/**
	 * modifies the survey definition and sets a new name and/or new responsible
	 */
	public void editSurveyDefinition() {
		UserBo user = manipulatedRow.getValue();
		SurveyDefinitionResponsibleUserPrivilegeBo sdrup = null;
		for (UserPrivilegeBo up : user.getPrivileges()) {
			if (up.getPrivilegeType().equals(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE) 
					&& ((SurveyDefinitionResponsibleUserPrivilegeBo)up).getSurveyDefinition().getId() 
						== addedSurveyDefinitionBo.getId()) {
				sdrup = (SurveyDefinitionResponsibleUserPrivilegeBo) up;
			}
		}
		user.getPrivileges().remove(sdrup);
		userFacade.save(user);
		//GIVE THE PRIVILEGE TO THE USER
		addedUserBo.getPrivileges().add(new SurveyDefinitionResponsibleUserPrivilegeBo(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, true, addedSurveyDefinitionBo));
		addedUserBo = userFacade.save(addedUserBo);
		//UPDATE THE LIST
		for (SurveyDefinitionBo bo : surveyDefinitions.keySet()) {
			if (bo.getId() == addedSurveyDefinitionBo.getId()) {
				bo.setName(addedSurveyDefinitionBo.getName());
				surveyDefinitions.put(bo, addedUserBo);
			}
		}
		surveyDefinitionFacade.save(addedSurveyDefinitionBo);
	}
	
	
	/*
	 *  Getters and Setters
	 */
	
	public UserBo getAddedUserBo() {
		return addedUserBo;
	}


	public void setAddedUserBo(UserBo addedUserBo) {
		this.addedUserBo = addedUserBo;
	}


	public Map<SurveyDefinitionBo, UserBo> getSurveyDefinitions() {
		return this.surveyDefinitions;
	}

	public void setSurveyDefinitions(Map<SurveyDefinitionBo, UserBo> surveyDefinitions) {
		this.surveyDefinitions = surveyDefinitions;
	}
	
	public SurveyDefinitionBo getAddedSurveyDefinitionBo() {
		return addedSurveyDefinitionBo;
	}

	public void setAddedSurveyDefinitionBo(SurveyDefinitionBo addedSurveyDefinitionBo) {
		this.addedSurveyDefinitionBo = addedSurveyDefinitionBo;
	}


	public Entry<SurveyDefinitionBo, UserBo> getManipulatedRow() {
		return manipulatedRow;
	}


	public void setManipulatedRow(Entry<SurveyDefinitionBo, UserBo> manipulatedRow) {
		this.manipulatedRow = manipulatedRow;
	}
		
}

