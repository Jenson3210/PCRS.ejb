package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;

@Named
@ViewScoped
public class RespSurveyDefinitionView implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * injection of the needed facade beans
	 */
	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;
	
	@EJB
	private ISurveySectionTitleFacade surveySectionTitleFacade;
	
	@EJB
	private ISurveySectionStrategyFacade surveySectionStrategyFacade;
	
	
	/*
	 * List for holding the data to be shown on the screen and/or dialog pop up
	 * 
	 */
	
	// list of survey definitions defined by the admin
	private List<SurveyDefinitionBo> surveyDefinitionList;
	
	// list of survey section titles defined by the admin
	private List<SurveySectionTitleBo> surveySectionTitleList;
	
	// list of survey strategies defined by the admin
	private List<SurveySectionStrategyBo> surveySectionStrategyList;
	
	
	// the added survey section definition
	private SurveySectionDefinitionBo addedSurveySectionDefinition;
	
	private SurveyDefinitionBo surveyDefinition;
	
	
	@Inject
	private WebUser webuser;
		
	
	public RespSurveyDefinitionView() {
	}

	@PostConstruct
	public void setup() {
		UserBo userBo = webuser.getUser();
		for (UserPrivilegeBo up : userBo.getPrivileges()) {
			System.out.println(up);
			if (up.getPrivilegeType().equals(PrivilegeType.SURVEYDEFINITIONRESPONSIBLE)) {
				surveyDefinition = ((SurveyUserPrivilegeBo) up).getSurveyDefinition();
			}
		}
		System.out.println("DEF: " + surveyDefinition);
		addedSurveySectionDefinition = new SurveySectionDefinitionBo();
		
		// get all definitions and titles
		surveyDefinitionList = surveyDefinitionFacade.getAll();
		surveySectionTitleList = surveySectionTitleFacade.getAll();
		surveySectionStrategyList = surveySectionStrategyFacade.getAll();

	}
	

	public void newSurveyDefinition() {
		addedSurveySectionDefinition = new SurveySectionDefinitionBo();
		
	}
	
	public void addSurveyDefinition() {
		System.out.println("++++++++++++++");
		System.out.println(addedSurveySectionDefinition.getSurveySectionTitle().getTitle());
		System.out.println(addedSurveySectionDefinition.getSurveySectionStrategy().getName());
	}
	
	
	/*
	 *  Getters and Setters
	 */
	
	public List<SurveyDefinitionBo> getSurveyDefinitionList() {
		return surveyDefinitionList;
	}

	public void setSurveyDefinitionList(List<SurveyDefinitionBo> surveyDefinitionList) {
		this.surveyDefinitionList = surveyDefinitionList;
	}


	public List<SurveySectionTitleBo> getSurveySectionTitleList() {
		return surveySectionTitleList;
	}

	public void setSurveySectionTitleList(List<SurveySectionTitleBo> surveySectionTitleList) {
		this.surveySectionTitleList = surveySectionTitleList;
	}

	public SurveySectionDefinitionBo getAddedSurveySectionDefinition() {
		return addedSurveySectionDefinition;
	}

	
	public void setAddedSurveySectionDefinition(SurveySectionDefinitionBo addedSurveySectionDefinition) {
		this.addedSurveySectionDefinition = addedSurveySectionDefinition;
	}

	public List<SurveySectionStrategyBo> getSurveySectionStrategyList() {
		return surveySectionStrategyList;
	}

	public void setSurveySectionStrategyList(List<SurveySectionStrategyBo> surveySectionStrategyList) {
		this.surveySectionStrategyList = surveySectionStrategyList;
	}

	public SurveyDefinitionBo getSurveyDefinition() {
		return surveyDefinition;
	}

	public void setSurveyDefinition(SurveyDefinitionBo surveyDefinition) {
		this.surveyDefinition = surveyDefinition;
	}
	
	
	
}
