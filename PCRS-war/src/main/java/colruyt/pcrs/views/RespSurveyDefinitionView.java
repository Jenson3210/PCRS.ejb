package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionRequirementLevelBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinition;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionImplFacade;
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
	
	@EJB
	private ISurveySectionDefinition surveySectionDefinitionFacade;
	
	@EJB
	private ISurveySectionDefinitionImplFacade surveySectionDefinitionImplFacade;
	
	
	/*
	 * List for holding the data to be shown on the screen and/or dialog pop up
	 * 
	 */
	
	// list of survey definitions assigned to the logged in user
	private List<SurveyDefinitionBo> assignedSurveyDefinitionList;
	
	// list of survey section definitions already defined
	private List<SurveySectionDefinitionBo> existingSurveySectionDefinitionList;
	
	// list of survey section titles defined by the admin
	private List<SurveySectionTitleBo> surveySectionTitleList;
	
	// list of survey strategies defined by the admin
	private List<SurveySectionStrategyBo> surveySectionStrategyList;
	
	private List<SurveySectionRequirementLevelBo> surveySectionRequirementLevels;
	
	
	// the added survey section definition
	private SurveySectionDefinitionBo addedSurveySectionDefinition;
	
	private SurveySectionRequirementLevelBo requirementLevel;
	
	@Inject
	private WebUser webuser;
		
	
	
	public RespSurveyDefinitionView() {
	}

	@PostConstruct
	public void setup() {
		UserBo userBo = webuser.getUser();
		assignedSurveyDefinitionList = new ArrayList<>();
		for (UserPrivilegeBo up : userBo.getPrivileges()) {
			System.out.println(up);
//			// check the privileges of the logged in user; if it is survey definition,
//			// add the survey definition to the corresponding list
			if (up.getPrivilegeType().equals(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE)) {
				assignedSurveyDefinitionList.add(((SurveyUserPrivilegeBo) up).getSurveyDefinition() );
			}
		}
		
		surveySectionTitleList = surveySectionTitleFacade.getAll();
		surveySectionStrategyList = surveySectionStrategyFacade.getAll();
		existingSurveySectionDefinitionList = surveySectionDefinitionFacade.getAll();
		surveySectionRequirementLevels =  Arrays.asList(SurveySectionRequirementLevelBo.values());
		this.newSurveyDefinition();
	}
	

	public void newSurveyDefinition() {
		addedSurveySectionDefinition = new SurveySectionDefinitionBo();
		
	}
	
	public void addSurveyDefinition() {
		System.out.println("++++++++++++++");
		// add the created survey section definition
		surveySectionDefinitionFacade.save(addedSurveySectionDefinition);
		
		SurveySectionDefinitionImplBo bo = new SurveySectionDefinitionImplBo(requirementLevel, addedSurveySectionDefinition);
		surveySectionDefinitionImplFacade.save(bo);
		
		
		System.out.println(addedSurveySectionDefinition.getSurveySectionTitle().getTitle());
		System.out.println(addedSurveySectionDefinition.getSurveySectionStrategy().getName());
		System.out.println(requirementLevel);
		
	}
	
	
	/*
	 *  Getters and Setters
	 */
	

	public List<SurveyDefinitionBo> getAssignedSurveyDefinitionList() {
		return assignedSurveyDefinitionList;
	}

	public void setAssignedSurveyDefinitionList(List<SurveyDefinitionBo> assignedSurveyDefinitionList) {
		this.assignedSurveyDefinitionList = assignedSurveyDefinitionList;
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

	public List<SurveySectionDefinitionBo> getExistingSurveySectionDefinitionList() {
		return existingSurveySectionDefinitionList;
	}

	public void setExistingSurveySectionDefinitionList(
			List<SurveySectionDefinitionBo> existingSurveySectionDefinitionList) {
		this.existingSurveySectionDefinitionList = existingSurveySectionDefinitionList;
	}

	public List<SurveySectionRequirementLevelBo> getSurveySectionRequirementLevels() {
		return surveySectionRequirementLevels;
	}

	public void setSurveySectionRequirementLevels(List<SurveySectionRequirementLevelBo> surveySectionRequirementLevels) {
		this.surveySectionRequirementLevels = surveySectionRequirementLevels;
	}

	public SurveySectionRequirementLevelBo getRequirementLevel() {
		return requirementLevel;
	}

	public void setRequirementLevel(SurveySectionRequirementLevelBo requirementLevel) {
		this.requirementLevel = requirementLevel;
	}	
	
}
