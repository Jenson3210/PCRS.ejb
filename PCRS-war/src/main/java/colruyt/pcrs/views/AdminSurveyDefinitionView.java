package colruyt.pcrs.views;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;


@Named
@ViewScoped
public class AdminSurveyDefinitionView implements Serializable{
	
	
	private static final long serialVersionUID = 5L;
	
	private List<SurveyDefinitionBo> surveyDefinitions;
	
	private SurveyDefinitionBo addedSurveyDefinitionBo;
	private UserBo addedUser;
	
	
	
	public UserBo getAddedUser() {
		return this.addedUser;
	}


	public void setAddedUser(UserBo addedUser) {
		this.addedUser = addedUser;
	}

	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;

	
	public AdminSurveyDefinitionView() {
		System.out.println("Inside constructor");
	}
	
	
	@PostConstruct
	public void setup() {
//		System.out.println("Inside @PostConstruct");
//		surveyDefinitions = surveyDefinitionFacade.getAll();
//		for (SurveyDefinitionBo bo : surveyDefinitions) {
//			System.out.println("BO: " + bo);
//			System.out.println("--------------");
//		}
		
	}
	
	
	public void newSurveyDefinition() {
		System.out.println("Inside newSurveyDefinition()");
		//surveyDefinitionBo = new SurveyDefinitionBo();
		//userBo = new UserBo();
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
		System.out.println("Inside addSurveyDefinition()");
	}
	
}

