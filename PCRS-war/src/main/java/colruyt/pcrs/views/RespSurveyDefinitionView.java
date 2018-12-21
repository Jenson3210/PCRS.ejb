package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

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
	private List<SurveySectionDefinitionBo> existingSurveySectionDefinitionList = new ArrayList<>();
	// list of survey section titles defined by the admin
	private List<SurveySectionTitleBo> surveySectionTitleList = new ArrayList<>();;
	// list of survey strategies defined by the admin
	private List<SurveySectionStrategyBo> surveySectionStrategyList = new ArrayList<>();;
	// list of the survey section requirement levels
	private List<SurveySectionRequirementLevelBo> surveySectionRequirementLevels = new ArrayList<>();
	private List<CompetenceBo> filteredResults = new ArrayList<>();
	
	private List<SurveySectionDefinitionBo> adminSurveySectionDefinitionList = new ArrayList<>();

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
	
	private CompetenceLevelBo selectedCompetenceLevel;
	
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
		assignedSurveyDefinitionList = surveyDefinitionFacade.getSurveyDefinitionsOfUser(webuser.getUser());
		this.activeTab = this.assignedSurveyDefinitionList.get(0);
	}
	

	/**
	 * Called when the Manage Sections button is clicked
	 */
	public void manageSectionsClickListener() {
		this.surveySectionTitleList = surveySectionTitleFacade.getAll();
		this.surveySectionStrategyList = surveySectionStrategyFacade.getAll();
		this.existingSurveySectionDefinitionList = surveySectionDefinitionFacade.getAll();
		this.addedSurveySectionDefinition = new SurveySectionDefinitionBo();
		this.surveySectionRequirementLevels =  Arrays.asList(SurveySectionRequirementLevelBo.values());
		//this.adminSurveySectionDefinitionList = surveySectionDefinitionFacade.getAll();
	}
	
	/**
	 * Called when the Manage Competences button is clicked
	 */
	public void manageCompetencesClickListener() {
		selectedSectionDefinitionImpl = new SurveySectionDefinitionImplBo();
		selectedCompetence = new CompetenceBo();
		addedCompetenceImplBo = new CompetenceImplBo();
		selectedMinLevel = new CompetenceLevelBo();
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
	
	
	/************************************************************************************************************************
	 *  													MANAGE COMPETENCE IMPLEMENTATIONS												*
	 ************************************************************************************************************************/
	
	/**
	 * Create new implementation of the competence with the selected attributes
	 * OK
	 */
	public void addNewCompetence() {
		PrimeFaces pf = PrimeFaces.current();
		
		Integer minLevel = null;
		
		// get section to add the competence to
		int index = getSection();
		
		// get tab of the section definition
		int tabIndex = getActiveIndex();
		
		// check whether the strategy requires a minimum level
		if(assignedSurveyDefinitionList.get(tabIndex).getSurveySections().get(index).getSurveySectionDefinitionBo()
			.getSurveySectionStrategy().getHasMinimumLevel()) {
			if (selectedMinLevel != null) {
				minLevel = selectedMinLevel.getOrderLevel();
			} else {
				// if not selected, lowest level is set
				minLevel = 1;
			}
		}
	
		SurveySectionDefinitionBo newBo;
		
		try {
			CompetenceImplBo bo = new CompetenceImplBo(selectedCompetence, selectedCompetence.getCompetenceDescription(), 
					minLevel);
			
			newBo = surveySectionDefinitionFacade.addCompetenceImpl(assignedSurveyDefinitionList.get(tabIndex).getSurveySections()
					.get(index).getSurveySectionDefinitionBo(), bo);
			
			// add the competence implementation to the correct section 
			assignedSurveyDefinitionList.get(tabIndex).getSurveySections().get(index).setSurveySectionDefinitionBo(newBo);
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("manageCompetences", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
		
	/**
	 * edit existing competenceImpl
	 */
	public void editCompetenceImpl() {
		PrimeFaces pf = PrimeFaces.current();
	
		int index = getSection();
		int tabIndex = getActiveIndex();
		
		this.addedCompetenceImplBo.setMinLevel(this.getSelectedCompetenceLevel().getOrderLevel());
		
		SurveySectionDefinitionBo newBo;
		
		try {
			newBo = surveySectionDefinitionFacade.addCompetenceImpl(assignedSurveyDefinitionList.get(tabIndex).getSurveySections()
					.get(index).getSurveySectionDefinitionBo(), this.addedCompetenceImplBo);
			
			// add the competence implementation to the correct section 
			assignedSurveyDefinitionList.get(tabIndex).getSurveySections().get(index).setSurveySectionDefinitionBo(newBo);
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("manageCompetences", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	
	/**
	 * delete competence implementation belonging to a certain section
	 */
	public void deleteCompetenceImpl() {
		PrimeFaces pf = PrimeFaces.current();
		
		int index = getSection();
		int tabIndex = getActiveIndex();
		
		SurveySectionDefinitionBo newBo;
		try {
			
			newBo = surveySectionDefinitionFacade.removeCompetenceImpl(assignedSurveyDefinitionList.get(tabIndex).getSurveySections()
					.get(index).getSurveySectionDefinitionBo(), addedCompetenceImplBo);
			
			assignedSurveyDefinitionList.get(tabIndex).getSurveySections().get(index).setSurveySectionDefinitionBo(newBo);
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
	
	
	/************************************************************************************************************************
	 *  													MANAGE SECTIONS											*
	 ************************************************************************************************************************/
	
	/**
	 * Method listener
	 */
	public void sectionChangeListener() {
		switch(newExistingOrDeleteSection) {
			case 0:
				addNewSection();
				break;
			case 2:
				deleteSection();
				break;
			default:
		}
	}
	
	
	/**
	 * create new implementation of a section definition
	 * OK
	 */
	private void addNewSection() {
		PrimeFaces pf = PrimeFaces.current();
		
		// save the survey definition and update the list
		SurveyDefinitionBo newBo;
		
		try {
			//create new implementation of the survey section definition
			SurveySectionDefinitionImplBo impl = new SurveySectionDefinitionImplBo(requirementLevel, addedSurveySectionDefinition);
			
			newBo = surveyDefinitionFacade.addSurveySectionDefinitionImpl(assignedSurveyDefinitionList.get(getActiveIndex()), impl);
			
			assignedSurveyDefinitionList.set(getActiveIndex(), newBo);
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("manageSections", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
		
	
	/**
	 * Delete section
	 * OK
	 */	
	private void deleteSection() {
		PrimeFaces pf = PrimeFaces.current();
		
		int tabIndex = getActiveIndex();
		SurveyDefinitionBo newBo;
		try {
			newBo = surveyDefinitionFacade.removeSurveySectionDefinitionImpl(assignedSurveyDefinitionList.get(tabIndex), 
					surveySectionDefinitionImplFacade.get(implToDelete));
			assignedSurveyDefinitionList.set(tabIndex, newBo);
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("manageSections", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
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
			if (bo.getName() != null && bo.getCompetenceDescription() != null) {
				if (bo.getName().toLowerCase().contains(query) || bo.getCompetenceDescription().toLowerCase().contains(query)) {
					newResults.add(bo);
				}
			} else if (bo.getName() != null && bo.getCompetenceDescription() == null) {
				if (bo.getName().toLowerCase().contains(query)) {
					newResults.add(bo);
				}
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
		query = query.toLowerCase();
		List<SurveySectionDefinitionImplBo> bos = new ArrayList<>();
		for (SurveySectionDefinitionImplBo bo : activeTab.getSurveySections()) {
			if (bo.getSurveySectionDefinitionBo().getSurveySectionTitle().getTitle().toLowerCase().contains(query)) {
				bos.add(bo);
			}
		}
		return bos;
	}

	
	/**
	 * Get the index of the tab (= survey definition ) which is active
	 * @return index
	 */
	private int getActiveIndex() {
		int index = -1;
		for (int i = 0; i < assignedSurveyDefinitionList.size(); i++) {
			SurveyDefinitionBo bo = assignedSurveyDefinitionList.get(i);
			if (bo.equals(activeTab)) {
				index = i;
			}
		}
		return index;
	}
	
	
	/**
	 * get index of the section which is currently being manipulated
	 * @return int index of the manipulated section
	 */
	private int getSection() {
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
		this.selectedCompetenceLevel = null;
		for(CompetenceLevelBo level : addedCompetenceImplBo.getCompetence().getCompetenceLevels()) {
			if (level.getOrderLevel().equals(addedCompetenceImplBo.getMinLevel())) {
				this.selectedCompetenceLevel = level;
			}
		}
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

	public List<SurveySectionDefinitionBo> getAdminSurveySectionDefinitionList() {
		return adminSurveySectionDefinitionList;
	}

	public void setAdminSurveySectionDefinitionList(List<SurveySectionDefinitionBo> adminSurveySectionDefinitionList) {
		this.adminSurveySectionDefinitionList = adminSurveySectionDefinitionList;
	}

	public CompetenceLevelBo getSelectedCompetenceLevel() {
		// set competence level of the selected competence
		return selectedCompetenceLevel;
	}

	public void setSelectedCompetenceLevel(CompetenceLevelBo levelBo) {
		this.selectedCompetenceLevel = levelBo;
	}
	
	
	
}