package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;

@Named
@ViewScoped
public class RespSurveyDefinition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@EJB
	private ISurveyDefinitionFacade surveyDefFacade;
	
	
	
	private List<SurveyDefinition> myDefinitions;
	
	@Inject
	private WebUser webuser;
	
	@PostConstruct
	private void init() {
		
		//NOP
	}

	public List<SurveyDefinition> getMyDefinitions() {
		return myDefinitions;
	}

	public void setMyDefinitions(List<SurveyDefinition> myDefinitions) {
		this.myDefinitions = myDefinitions;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
	
}
