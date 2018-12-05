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

import org.primefaces.event.TabChangeEvent;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.competence.CompetenceImplBo;
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
import colruyt.pcrsejb.facade.competence.ICompetenceImplFacade;
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
	
	@EJB
	private ICompetenceImplFacade competenceImplFacade;
	
	
	
	/*
	 * List for holding the data to be shown on the screen and/or dialog pop up
	 */
	
	// list of survey definitions assigned to the logged in user
	private List<SurveyDefinitionBo> assignedSurveyDefinitionList;
	
	// list of survey section definitions already defined
	private List<SurveySectionDefinitionBo> existingSurveySectionDefinitionList;
	
	// list of survey section titles defined by the admin
	private List<SurveySectionTitleBo> surveySectionTitleList;
	
	// list of survey strategies defined by the admin
	private List<SurveySectionStrategyBo> surveySectionStrategyList;
	
	// list of the survey section requirement levels
	private List<SurveySectionRequirementLevelBo> surveySectionRequirementLevels;
	
	// list of all the existing competences
	private List<CompetenceImplBo> existingCompetences;
	
	private CompetenceImplBo addedCompetence;
	
	// the added survey section definition
	private SurveySectionDefinitionBo addedSurveySectionDefinition;
	
	// active tab 
	private SurveyDefinitionBo activeTab;
	
	// selected requirement level
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
			// check the privileges of the logged in user; if it is survey definition,
			// add the survey definition to the corresponding list
			if (up.getPrivilegeType().equals(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE)) {
				assignedSurveyDefinitionList.add(((SurveyUserPrivilegeBo) up).getSurveyDefinition() );
			}
		}
		
		this.surveySectionTitleList = surveySectionTitleFacade.getAll();
		this.surveySectionStrategyList = surveySectionStrategyFacade.getAll();
		this.existingSurveySectionDefinitionList = surveySectionDefinitionFacade.getAll();
		this.surveySectionRequirementLevels =  Arrays.asList(SurveySectionRequirementLevelBo.values());
		this.existingCompetences = competenceImplFacade.getAll();
		this.newSurveyDefinition();
	}
	
	
	public void newSurveyDefinition() {
		addedSurveySectionDefinition = new SurveySectionDefinitionBo();
	}
	
	public void newCompetence() {
		addedCompetence = new CompetenceImplBo();
	}
	
	public void addNewSurveyDefinition() {
		// add the created survey section definition
		//this.addedSurveySectionDefinition = this.surveySectionDefinitionFacade.save(this.addedSurveySectionDefinition);
		SurveySectionDefinitionImplBo bo = new SurveySectionDefinitionImplBo(this.requirementLevel, this.addedSurveySectionDefinition);
		this.assignedSurveyDefinitionList.get(getActiveIndex()).addSurveySection(bo);
		SurveyDefinitionBo bb = this.surveyDefinitionFacade.save(this.assignedSurveyDefinitionList.get(getActiveIndex()));
		this.assignedSurveyDefinitionList.set(getActiveIndex(), bb);
	}
	
	public void addExistingSurveyDefinition() {
		// TEMPORARY: get the full SurveySectionDefinition from the DB
		//create new Implementation, add it to the Survey Definition
		SurveySectionDefinitionImplBo bo = new SurveySectionDefinitionImplBo(this.requirementLevel, 
				surveySectionDefinitionFacade.get(this.addedSurveySectionDefinition));
		this.assignedSurveyDefinitionList.get(getActiveIndex()).addSurveySection(bo);
		SurveyDefinitionBo bb = this.surveyDefinitionFacade.save(this.assignedSurveyDefinitionList.get(getActiveIndex()));
		this.assignedSurveyDefinitionList.set(getActiveIndex(), bb);


		
		
	}
	
	public int getActiveIndex() {
		int index = -1;
		for (int i = 0; i < assignedSurveyDefinitionList.size(); i++) {
			SurveyDefinitionBo bo = assignedSurveyDefinitionList.get(i);
			if (bo.equals(activeTab)) {
				index = i;
			}
		}
		return index;
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

	public SurveyDefinitionBo getActiveTab() {
		return activeTab;
	}

	public void setActiveTab(SurveyDefinitionBo activeTab) {
		this.activeTab = activeTab;
	}
	
}
