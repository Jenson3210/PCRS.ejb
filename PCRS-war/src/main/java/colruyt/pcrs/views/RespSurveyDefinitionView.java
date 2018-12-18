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
import colruyt.pcrsejb.bo.competence.CompetenceLevelBo;
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
import colruyt.pcrsejb.facade.competence.ICompetenceImplFacade;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionImplFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

/**
 * RESPONSIBLE SURVEY DEFINITION VIEW
 * @author jda1mbw
 */
@Named
@ViewScoped
public class RespSurveyDefinitionView implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Injection of the needed facade beans and user
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
	@EJB
	private ICompetenceImplFacade competenceImplFacade;
	@Inject
	private WebUser webuser;
	
	/**
	 * List for holding the data to be shown on the screen and/or dialog pop up
	 */
	// list of survey definitions assigned to the logged in user
	private List<SurveyDefinitionBo> assignedSurveyDefinitionList = new ArrayList<>();
	// list of survey section definitions already defined
	private List<SurveySectionDefinitionBo> existingSurveySectionDefinitionList = new ArrayList<>();;
	// list of survey section titles defined by the admin
	private List<SurveySectionTitleBo> surveySectionTitleList = new ArrayList<>();;
	// list of survey strategies defined by the admin
	private List<SurveySectionStrategyBo> surveySectionStrategyList = new ArrayList<>();;
	// list of the survey section requirement levels
	private List<SurveySectionRequirementLevelBo> surveySectionRequirementLevels = new ArrayList<>();
	private List<CompetenceBo> filteredResults = new ArrayList<>();

	private SurveySectionDefinitionImplBo selectedSectionDefinitionImpl; 
	private CompetenceBo selectedCompetence;
	private CompetenceImplBo addedCompetenceImplBo;
	private CompetenceLevelBo selectedMinLevel;

	// current active tab of the user
	private SurveyDefinitionBo activeTab;
	private SurveySectionDefinitionImplBo implToDelete;
	private Integer intSelected;

	// integer keeping track of the radio button selected on the dialog
	// when managing sections
	private int newExistingOrDeleteSection;	
	// selected requirement level when adding a section
	private SurveySectionRequirementLevelBo requirementLevel;	
	// selected or created survey section definition when adding a section
	private SurveySectionDefinitionBo addedSurveySectionDefinition;
	
	/**
	 * Default constructor
	 */
	public RespSurveyDefinitionView() {
	}

	/**
	 * Setup of the screen, loading the needed data
	 */
	@PostConstruct
	public void setup() {
		UserBo userBo = webuser.getUser();
		//List<SurveyDefinitionBo> bos = surveyDefinitionFacade.getSurveyDefinitionsOfUser(userBo);
		assignedSurveyDefinitionList = new ArrayList<>();
		for (UserPrivilegeBo up : userBo.getPrivileges()) {
			System.out.println(up);
			// check the privileges of the logged in user; if it is survey definition,
			// add the survey definition to the corresponding list
			if (up.getPrivilegeType().equals(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE)) {
				assignedSurveyDefinitionList.add(((SurveyUserPrivilegeBo) up).getSurveyDefinition() );
			}
		}
		
		this.activeTab = this.assignedSurveyDefinitionList.get(0);
	}
	
	/**
	 * Called when the Manage Sections button is clicked
	 */
	public void manageSectionsClickListener() {
		this.surveySectionTitleList = surveySectionTitleFacade.getAll();
		this.surveySectionStrategyList = surveySectionStrategyFacade.getAll();
		this.existingSurveySectionDefinitionList = surveySectionDefinitionFacade.getAll();
		this.surveySectionRequirementLevels =  Arrays.asList(SurveySectionRequirementLevelBo.values());
	}
	
	/**
	 * Called when the Manage Competences button is clicked
	 */
	public void manageCompetencesClickListener() {
		selectedSectionDefinitionImpl = new SurveySectionDefinitionImplBo();
		selectedCompetence = new CompetenceBo();
		addedCompetenceImplBo = new CompetenceImplBo();
	}
	
	/**
	 * Create new survey definition
	 */
	public void newSurveyDefinition() {
		addedSurveySectionDefinition = new SurveySectionDefinitionBo();
	}
	
	/**
	 * Create new competence
	 */
	public void newCompetence() {
		selectedCompetence = new CompetenceBo();
	}
	
	/**
	 * Create new implementation of the competence with the selected attributes
	 */
	public void addNewCompetence() {
		Integer minLevel = null;
		if (selectedMinLevel != null) {
			minLevel = selectedMinLevel.getOrderLevel();
		}
		
		CompetenceImplBo bo = new CompetenceImplBo(selectedCompetence, selectedCompetence.getCompetenceDescription(), 
				minLevel);
		
		int index = getSection();
		
		// add the competence implementation to the correct section 
		assignedSurveyDefinitionList.get(getActiveIndex()).getSurveySections().get(index).getSurveySectionDefinitionBo()
			.getSurveySectionCompetences().add(bo);
		
		SurveyDefinitionBo newBo;
		try {
			newBo = surveyDefinitionFacade.save(assignedSurveyDefinitionList.get(getActiveIndex()));
			assignedSurveyDefinitionList.set(getActiveIndex(), newBo);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	/**
	 * Complete method for autocomplete textbox
	 * @param query: text typed in by the user in the input field 
	 * @return: List of CompetenceBo objects for which the title and/or description
	 * 			match the query 
	 */
	public List<CompetenceBo> completeCompetence(String query) {
		List<CompetenceBo> newResults = new ArrayList<>();
		query = query.toLowerCase();
		for (CompetenceBo bo : filteredResults) {
			// filter on name and description
			if (bo.getName().toLowerCase().contains(query) || 
					bo.getCompetenceDescription().toLowerCase().contains(query)) {
				newResults.add(bo);
			}
		}
		return newResults;
	}
	
	/**
	 * Method to return list of survey section definitions
	 * @param query
	 * @return bos
	 */
	public List<SurveySectionDefinitionImplBo> completeSection(String query){
		List<SurveySectionDefinitionImplBo> bos = new ArrayList<>();
		for (SurveySectionDefinitionImplBo bo : activeTab.getSurveySections()) {
			if (bo.getSurveySectionDefinitionBo().getSurveySectionTitle().getTitle().contains(query)) {
				bos.add(bo);
			}
		}
		return bos;
	}

	/**
	 * Method listener
	 */
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
		SurveyDefinitionBo newBo;
		try {
			newBo = surveyDefinitionFacade.save(assignedSurveyDefinitionList.get(getActiveIndex()));
			assignedSurveyDefinitionList.set(getActiveIndex(), newBo);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Add existing section
	 */
	private void addExistingSection() {
		// TEMPORARY: get the full SurveySectionDefinition from the DB
		try {
			addedSurveySectionDefinition = surveySectionDefinitionFacade.get(addedSurveySectionDefinition);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create new Implementation, add it to the Survey Definition
		SurveySectionDefinitionImplBo bo = new SurveySectionDefinitionImplBo(requirementLevel, addedSurveySectionDefinition);
		assignedSurveyDefinitionList.get(getActiveIndex()).getSurveySections().add(bo);
		SurveyDefinitionBo newBo;
		try {
			newBo = surveyDefinitionFacade.save(assignedSurveyDefinitionList.get(getActiveIndex()));
			assignedSurveyDefinitionList.set(getActiveIndex(), newBo);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Delete section
	 */
	private void deleteSection() {
		try {
			implToDelete = surveySectionDefinitionImplFacade.get(implToDelete);
			assignedSurveyDefinitionList.get(getActiveIndex()).getSurveySections().remove(implToDelete);
			SurveyDefinitionBo newBo = surveyDefinitionFacade.save(assignedSurveyDefinitionList.get(getActiveIndex()));
			assignedSurveyDefinitionList.set(getActiveIndex(), newBo);
			surveySectionDefinitionImplFacade.delete(implToDelete);
		} catch (ValidationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}			
	}
	
	private void editCompetenceImpl() {
		CompetenceImplBo bo = new CompetenceImplBo();
	
		//for (CompetenceImplBo bos : )
		
		int index = getSection();
		
		// loop over the competence in the this list
		for(CompetenceImplBo bos : assignedSurveyDefinitionList.get(getActiveIndex()).getSurveySections().get(index).
				getSurveySectionDefinitionBo().getSurveySectionCompetences()) {
			if (bos.getId().equals(addedCompetenceImplBo.getId())) {
				bos.setCompetenceDescription(addedCompetenceImplBo.getCompetenceDescription());
				bos.setMinLevel(addedCompetenceImplBo.getMinLevel());
			}
			bo = bos;
		}
		
		try {
			competenceImplFacade.save(bo);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * Get the index
	 * @return index
	 */
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
	
	public int getSection() {
		int index = -1;
		
		// get section for which we edit the competenceImpl
		for(int i =0; i < assignedSurveyDefinitionList.get(getActiveIndex()).getSurveySections().size(); i++) {
			SurveySectionDefinitionImplBo impl = assignedSurveyDefinitionList.get(getActiveIndex()).getSurveySections().get(i);
			if (impl.getId().equals(getSelectedSectionDefinitionImpl().getId())) {
				index = i;
			}
		}
		return index;
	}
	
	/**
	 * Method to check if the competence is selected
	 * @return isCompetenceSelected
	 */
	public boolean isCompetenceSelected() {
		boolean isCompetenceSelected = false;
		if (selectedCompetence != null && selectedCompetence.getName() != null) {
			isCompetenceSelected = true;
		}
		return isCompetenceSelected;
	}
	

	public void deleteCompetenceImpl() {
		try {
			
			competenceImplFacade.delete(addedCompetenceImplBo);
			int index = getSection();
			assignedSurveyDefinitionList.get(getActiveIndex()).getSurveySections().get(index).getSurveySectionDefinitionBo()
			.getSurveySectionCompetences().remove(addedCompetenceImplBo);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	
	}

	/************************************************************************************************************************
	 *  													Getters and Setters												*
	 ************************************************************************************************************************/
	
	/**
	 * Get the assigned survey definition list
	 * @return assignedSurveyDefinitionList
	 */
	public List<SurveyDefinitionBo> getAssignedSurveyDefinitionList() {
		return assignedSurveyDefinitionList;
	}

	/**
	 * Set the assigned survey definition list
	 * @param assignedSurveyDefinitionList
	 */
	public void setAssignedSurveyDefinitionList(List<SurveyDefinitionBo> assignedSurveyDefinitionList) {
		this.assignedSurveyDefinitionList = assignedSurveyDefinitionList;
	}

	/**
	 * Get list of survey section title
	 * @return surveySectionTitleList
	 */
	public List<SurveySectionTitleBo> getSurveySectionTitleList() {
		return surveySectionTitleList;
	}

	/**
	 * Set list of survey section title
	 * @param surveySectionTitleList
	 */
	public void setSurveySectionTitleList(List<SurveySectionTitleBo> surveySectionTitleList) {
		this.surveySectionTitleList = surveySectionTitleList;
	}

	/**
	 * Get the added Survey section definition
	 * @return addedSurveySectionDefinition
	 */
	public SurveySectionDefinitionBo getAddedSurveySectionDefinition() {
		return addedSurveySectionDefinition;
	}


	/**
	 * Set the added Survey section definition
	 * @param addedSurveySectionDefinition
	 */
	public void setAddedSurveySectionDefinition(SurveySectionDefinitionBo addedSurveySectionDefinition) {
		this.addedSurveySectionDefinition = addedSurveySectionDefinition;
	}

	/**
	 * Get a list of survey section strategy
	 * @return surveySectionStrategyList
	 */
	public List<SurveySectionStrategyBo> getSurveySectionStrategyList() {
		return surveySectionStrategyList;
	}

	/**
	 * Set a list of survey section strategy
	 * @param surveySectionStrategyList
	 */
	public void setSurveySectionStrategyList(List<SurveySectionStrategyBo> surveySectionStrategyList) {
		this.surveySectionStrategyList = surveySectionStrategyList;
	}

	/**
	 * Get a list of existing survey section definitions
	 * @return existingSurveySectionDefinitionList
	 */
	public List<SurveySectionDefinitionBo> getExistingSurveySectionDefinitionList() {
		return existingSurveySectionDefinitionList;
	}

	/**
	 * Set a list of existing survey section definitions
	 * @param existingSurveySectionDefinitionList
	 */
	public void setExistingSurveySectionDefinitionList(
			List<SurveySectionDefinitionBo> existingSurveySectionDefinitionList) {
		this.existingSurveySectionDefinitionList = existingSurveySectionDefinitionList;
	}

	/**
	 * Get a list of survey section requirement levels
	 * @return surveySectionRequirementLevels
	 */
	public List<SurveySectionRequirementLevelBo> getSurveySectionRequirementLevels() {
		return surveySectionRequirementLevels;
	}

	/**
	 * Set a list of survey section requirement levels
	 * @param surveySectionRequirementLevels
	 */
	public void setSurveySectionRequirementLevels(List<SurveySectionRequirementLevelBo> surveySectionRequirementLevels) {
		this.surveySectionRequirementLevels = surveySectionRequirementLevels;
	}

	/**
	 * Get a list of requirement levels
	 * @return requirementLevel
	 */
	public SurveySectionRequirementLevelBo getRequirementLevel() {
		return requirementLevel;
	}

	/**
	 * Set a list of requirement levels
	 * @param requirementLevel
	 */
	public void setRequirementLevel(SurveySectionRequirementLevelBo requirementLevel) {
		this.requirementLevel = requirementLevel;
	}

	/**
	 * Get active tab
	 * @return activeTab
	 */
	public SurveyDefinitionBo getActiveTab() {
		return activeTab;
	}

	/**
	 * Set active tab
	 * @param activeTab
	 */
	public void setActiveTab(SurveyDefinitionBo activeTab) {
		this.activeTab = activeTab;
	}

	/**
	 * Get new, existing or delete section
	 * @return newExistingOrDeleteSection
	 */
	public int getNewExistingOrDeleteSection() {
		return newExistingOrDeleteSection;
	}

	/**
	 * Set new, existing or delete section
	 * @param newExistingOrDeleteSection
	 */
	public void setNewExistingOrDeleteSection(int newExistingOrDeleteSection) {
		this.newExistingOrDeleteSection = newExistingOrDeleteSection;
	}

	/**
	 * Get the impl to delete
	 * @return implToDelete 
	 */
	public SurveySectionDefinitionImplBo getImplToDelete() {
		return implToDelete;
	}

	/**
	 * Set the impl to delete
	 * @param implToDelete
	 */
	public void setImplToDelete(SurveySectionDefinitionImplBo implToDelete) {
		this.implToDelete = implToDelete;
	}

	/**
	 * Get selected competence
	 * @return selectedCompetence
	 */
	public CompetenceBo getSelectedCompetence() {
		return selectedCompetence;
	}

	/**
	 * Set selected competence
	 * @param selectedCompetence
	 */
	public void setSelectedCompetence(CompetenceBo selectedCompetence) {
		if (selectedCompetence.getName() == null) {
			try {
				this.selectedCompetence = competenceFacade.get(selectedCompetence);
			} catch (ValidationException e) {
				e.printStackTrace();
			}
		} else {
			this.selectedCompetence = selectedCompetence;
		}
	}

	/**
	 * Get added competence
	 * @return addedCompetenceImplBo
	 */
	public CompetenceImplBo getAddedCompetenceImplBo() {
		return addedCompetenceImplBo;
	}

	/**
	 * Set added competence
	 * @param addedCompetenceImplBo
	 */
	public void setAddedCompetenceImplBo(CompetenceImplBo addedCompetenceImplBo) {
		this.addedCompetenceImplBo = addedCompetenceImplBo;
	}

	/**
	 * Get selected minimum level
	 * @return selectedMinLevel
	 */
	public CompetenceLevelBo getSelectedMinLevel() {
		return selectedMinLevel;
	}

	/**
	 * Set selected minimum level
	 * @param selectedMinLevel
	 */
	public void setSelectedMinLevel(CompetenceLevelBo selectedMinLevel) {
		this.selectedMinLevel = selectedMinLevel;
	}

	/**
	 * Get selected section definition
	 * @return selectedSectionDefinitionImpl
	 */
	public SurveySectionDefinitionImplBo getSelectedSectionDefinitionImpl() {
		return selectedSectionDefinitionImpl;
	}

	/**
	 * Set selected section definition
	 * @param selectedSectionDefinitionImpl
	 */
	public void setSelectedSectionDefinitionImpl(SurveySectionDefinitionImplBo selectedSectionDefinitionImpl) {
		if (selectedSectionDefinitionImpl.getSurveySectionDefinitionBo() == null) {
			try {
				this.selectedSectionDefinitionImpl = surveySectionDefinitionImplFacade.get(selectedSectionDefinitionImpl);
			} catch (ValidationException e) {
				e.printStackTrace();
			}
			this.filteredResults = competenceFacade.getCompetencesBySection(this.selectedSectionDefinitionImpl);
		} else {
			this.selectedSectionDefinitionImpl = selectedSectionDefinitionImpl;
		}
	}
	
	/**
	 * Get selected int
	 * @return intSelected
	 */
	public Integer getIntSelected() {
		return intSelected;
	}

	/**
	 * Set selected int
	 * @param intSelected
	 */
	public void setIntSelected(Integer intSelected) {
		this.intSelected = intSelected;
	}


	/**
	 * Get list of filtered results
	 * @return
	 */
	public List<CompetenceBo> getFilteredResults() {
		return filteredResults;
	}

	/**
	 * Set list of filtered results
	 * @param filteredResults
	 */
	public void setFilteredResults(List<CompetenceBo> filteredResults) {
		this.filteredResults = filteredResults;
	}
}