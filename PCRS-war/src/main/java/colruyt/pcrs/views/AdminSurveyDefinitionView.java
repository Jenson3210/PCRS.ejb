package colruyt.pcrs.views;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;


@Named
@ViewScoped
public class AdminSurveyDefinitionView implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	private List<SurveyDefinitionBo> surveyDefinitions;
	
	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;

	
	public AdminSurveyDefinitionView() {
		
	}
	
	@PostConstruct
	public void setup() {
		surveyDefinitions = surveyDefinitionFacade.getAll();
		for (SurveyDefinitionBo bo : surveyDefinitions) {
			System.out.println("BO: " + bo);
		}
		
	}

	public List<SurveyDefinitionBo> getSurveyDefinitions() {
		return surveyDefinitions;
	}

	public void setSurveyDefinitions(List<SurveyDefinitionBo> surveyDefinitions) {
		this.surveyDefinitions = surveyDefinitions;
	}
	
	
	
	
	
	
}

