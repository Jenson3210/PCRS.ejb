package colruyt.pcrs.views;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
		addedUserBo = new UserBo();
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
		System.out.println("Inside addSurveyDefinition()");
		System.out.println("---------");
		System.out.println("Title " + addedSurveyDefinitionBo.getName());
		System.out.println("User " + addedUserBo.getEmail());
	}
	
	public List<String> completeShortName(String query){
		List<UserBo> matchingUsers = new ArrayList<>();
		
		List<String> autoCompleteList = new ArrayList<>();
		
		// look for users with short name = query
		//matchingUsers = userFacade.getUsersByShortName(query);
		
		for (UserBo userBo : matchingUsers) {
			autoCompleteList.add(userBo.getEmail());
		}
		
		return autoCompleteList;
	}
	
}

