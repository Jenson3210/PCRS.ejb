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
import colruyt.pcrsejb.bo.competence.CompetenceBo;
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
import colruyt.pcrsejb.facade.competence.ICompetenceFacade;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionImplFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;

@Named
@ViewScoped
public class RespSurveyDefinitionView implements Serializable {

	private static final long serialVersionUID = 1L;

	/*
	 * injection of the needed facade beans and user
	 */
	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;
	@EJB
	private ISurveySectionTitleFacade surveySectionTitleFacade;
	@EJB
	private ISurveySectionStrategyFacade surveySectionStrategyFacade;
	@EJB
	private ISurveySectionDefinitionFacade surveySectionDefinitionFacade;
	@EJB
	private ISurveySectionDefinitionImplFacade surveySectionDefinitionImplFacade;
	@EJB
	private ICompetenceFacade competenceFacade;
	@Inject
	private WebUser webuser;
	
	
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
	private List<CompetenceBo> existingCompetences;
	
	private CompetenceBo selectedCompetence;
	
	
	
	// current active tab of the user
	private SurveyDefinitionBo activeTab;
	
	private SurveySectionDefinitionImplBo implToDelete;
	
	
	
	// integer keeping track of the radio button selected on the dialog
	// when managing sections
	private int newExistingOrDeleteSection;
		
	// selected requirement level when adding a section
	private SurveySectionRequirementLevelBo requirementLevel;
		
	// selected or created survey section definition when adding a section
	private SurveySectionDefinitionBo addedSurveySectionDefinition;
	
	
	
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
		this.existingCompetences = competenceFacade.getAll();
		System.out.println(existingCompetences.size());
		this.newSurveyDefinition();
		this.activeTab = this.assignedSurveyDefinitionList.get(0);
	}
	
	
	
	public void newSurveyDefinition() {
		addedSurveySectionDefinition = new SurveySectionDefinitionBo();
	}
	
	public void newCompetence() {
		selectedCompetence = new CompetenceBo();
	}
	
	public void manageCompetences() {
	
		
	}
	
	
	public List<CompetenceBo> completeCompetence(String query) {
		List<CompetenceBo> filteredResults = new ArrayList<>();
		query = query.toLowerCase();
		for (CompetenceBo bo : existingCompetences) {
			if (bo.getName().toLowerCase().contains(query) || 
					bo.getCompetenceDescription().toLowerCase().contains(query)) {
				filteredResults.add(bo);
			}
		}
		return filteredResults;
	}
	
	
	public void addNewSurveyDefinition() {
		// add the created survey section definition
		
	}
	
	public void addExistingSurveyDefinition() {
		
		
	}
	
	
	
	public void sectionChangeListener() {
		switch(newExistingOrDeleteSection) {
		case 0:
			addNewSection();
			break;
		case 1:
			addExistingSection();
			break;
		case 2:
			deleteSection();
			break;
		default:
		}
	}
	
	/**
	 * create new implementation of a section definition
	 */
	private void addNewSection() {
		//create new implementation of the survey section definition
		SurveySectionDefinitionImplBo impl = new SurveySectionDefinitionImplBo(requirementLevel, addedSurveySectionDefinition);
		// add the implementation to the active survey definition
		assignedSurveyDefinitionList.get(getActiveIndex()).getSurveySections().add(impl);
		// save the survey definition and update the list
		SurveyDefinitionBo newBo = surveyDefinitionFacade.save(assignedSurveyDefinitionList.get(getActiveIndex()));
		assignedSurveyDefinitionList.set(getActiveIndex(), newBo);
	}

	
	
	private void addExistingSection() {
		// TEMPORARY: get the full SurveySectionDefinition from the DB
		addedSurveySectionDefinition = surveySectionDefinitionFacade.get(addedSurveySectionDefinition);
		//create new Implementation, add it to the Survey Definition
		SurveySectionDefinitionImplBo bo = new SurveySectionDefinitionImplBo(requirementLevel, addedSurveySectionDefinition);
		assignedSurveyDefinitionList.get(getActiveIndex()).getSurveySections().add(bo);
		SurveyDefinitionBo newBo = surveyDefinitionFacade.save(assignedSurveyDefinitionList.get(getActiveIndex()));
		assignedSurveyDefinitionList.set(getActiveIndex(), newBo);
	}
	
	private void deleteSection() {
		implToDelete = surveySectionDefinitionImplFacade.get(implToDelete);
		assignedSurveyDefinitionList.get(getActiveIndex()).getSurveySections().remove(implToDelete);
		SurveyDefinitionBo newBo = surveyDefinitionFacade.save(assignedSurveyDefinitionList.get(getActiveIndex()));
		assignedSurveyDefinitionList.set(getActiveIndex(), newBo);
		surveySectionDefinitionImplFacade.delete(implToDelete);
	}

	public void manageSections() {
	
		
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

	public int getNewExistingOrDeleteSection() {
		return newExistingOrDeleteSection;
	}

	public void setNewExistingOrDeleteSection(int newExistingOrDeleteSection) {
		this.newExistingOrDeleteSection = newExistingOrDeleteSection;
	}

	public SurveySectionDefinitionImplBo getImplToDelete() {
		return implToDelete;
	}

	public void setImplToDelete(SurveySectionDefinitionImplBo implToDelete) {
		this.implToDelete = implToDelete;
	}

	public CompetenceBo getSelectedCompetence() {
		return selectedCompetence;
	}

	public void setSelectedCompetence(CompetenceBo selectedCompetence) {
		if (selectedCompetence.getName() == null) {
			this.selectedCompetence = competenceFacade.get(selectedCompetence);
		}
	}
		

}
