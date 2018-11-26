package colruyt.pcrs.views;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;


@Named
@ViewScoped
public class AdminSurveyDefinitionView implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private List<SurveyDefinitionBo> surveyDefinitions;
	
	private SurveyDefinitionBo addedSurveyDefinitionBo;
	private UserBo addedUser;
	
	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;

	
	public AdminSurveyDefinitionView() {
		
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
		//surveyDefinitionBo = new SurveyDefinitionBo();
		//userBo = new UserBo();
	}
	
	
	
	public List<SurveyDefinitionBo> getSurveyDefinitions() {
		return surveyDefinitions;
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

	public UserBo getAddedUser() {
		return addedUser;
	}

	public void setAddedUser(UserBo addedUser) {
		this.addedUser = addedUser;
	}

	public void addSurveyDefinition() {
		System.out.println("Inside addSurveyDefinition()");
	}
	
}

