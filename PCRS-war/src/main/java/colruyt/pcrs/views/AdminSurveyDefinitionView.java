package colruyt.pcrs.views;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;


@Named
@ViewScoped
public class AdminSurveyDefinitionView implements Serializable{
	
	
	private static final long serialVersionUID = 5L;
	
	@EJB
	private IUserFacade userFacade;
	
	private List<SurveyDefinitionBo> surveyDefinitions;
	
	private SurveyDefinitionBo addedSurveyDefinitionBo;
	private UserBo addedUserBo;
	

	
	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;

	
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
		System.out.println("POST");
		surveyDefinitions = surveyDefinitionFacade.getAll();
		for (SurveyDefinitionBo bo : surveyDefinitions) {
			System.out.println("BO: " + bo);
		}
	}
	
	
	public void newSurveyDefinition() {
		addedSurveyDefinitionBo = new SurveyDefinitionBo();
	}
	

	public void addSurveyDefinition() {
		surveyDefinitions.add(surveyDefinitionFacade.save(addedSurveyDefinitionBo));	
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
		surveyDefinitions.remove(addedSurveyDefinitionBo);
		surveyDefinitionFacade.delete(addedSurveyDefinitionBo);
	}
	
	/**
	 * modifies the survey definition and sets a new name and/or new responsible
	 */
	public void editSurveyDefinition() {
		for (SurveyDefinitionBo bo : surveyDefinitions) {
			if (bo.getId() == addedSurveyDefinitionBo.getId()) {
				bo.setName(addedSurveyDefinitionBo.getName());
				bo.setResponsibleUser(addedSurveyDefinitionBo.getResponsibleUser());
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


	public List<SurveyDefinitionBo> getSurveyDefinitions() {
		return this.surveyDefinitions;
	}

	public void setSurveyDefinitions(List<SurveyDefinitionBo> surveyDefinitions) {
		this.surveyDefinitions = surveyDefinitions;
	}
	
	public SurveyDefinitionBo getAddedSurveyDefinitionBo() {
		return addedSurveyDefinitionBo;
	}

	public void setAddedSurveyDefinitionBo(SurveyDefinitionBo addedSurveyDefinitionBo) {
		this.addedSurveyDefinitionBo = addedSurveyDefinitionBo;
	}

	
	
	
}

