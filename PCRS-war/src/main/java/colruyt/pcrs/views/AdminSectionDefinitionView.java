package colruyt.pcrs.views;


import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import colruyt.pcrsejb.facade.surveyDefinition.survey.SurveyDefinitionFacade;


@Named
@ViewScoped
public class AdminSectionDefinitionView implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private SurveyDefinitionFacade surveyDefinitionFacade;

	
	public AdminSectionDefinitionView() {

	}
	
	
	@PostConstruct
	public void setup() {
		
	}
	
	


	
	
	
	

	
}

