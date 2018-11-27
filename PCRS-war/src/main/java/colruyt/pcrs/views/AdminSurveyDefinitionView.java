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
	private List<UserBo> matchingUsers;
	
	private SurveyDefinitionBo addedSurveyDefinitionBo;
	private UserBo addedUserBo;
	

	
	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;

	
	public AdminSurveyDefinitionView() {
		System.out.println("Inside constructor");
	}
	
	
	@PostConstruct
	public void setup() {
		System.out.println("Inside @PostConstruct");
		surveyDefinitions = surveyDefinitionFacade.getAll();
		for (SurveyDefinitionBo bo : surveyDefinitions) {
			System.out.println("BO: " + bo);
		}
	}
	
	
	public void newSurveyDefinition() {
		System.out.println("Inside newSurveyDefinition()");
		addedSurveyDefinitionBo = new SurveyDefinitionBo();
	}
	

	
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

	
	public void addSurveyDefinition() {
		surveyDefinitions.add(surveyDefinitionFacade.save(addedSurveyDefinitionBo));	
	}
	
	public List<UserBo> completeShortName(String query){
		return userFacade.getUsersByShortName("%" + query + "%");
	}
	
	
	public void deleteSurveyDefinition(){
		surveyDefinitions.remove(addedSurveyDefinitionBo);
		surveyDefinitionFacade.delete(addedSurveyDefinitionBo);
	}
	
	public void editSurveyDefinition() {
		for (SurveyDefinitionBo bo : surveyDefinitions) {
			if (bo.getId() == addedSurveyDefinitionBo.getId()) {
				bo.setName(addedSurveyDefinitionBo.getName());
				bo.setResponsibleUser(addedSurveyDefinitionBo.getResponsibleUser());
			}
		}
		surveyDefinitionFacade.save(addedSurveyDefinitionBo);
	}
}

