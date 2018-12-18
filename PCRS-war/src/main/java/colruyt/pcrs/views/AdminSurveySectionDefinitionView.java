package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

/**
 * ADMIN SURVEY SECTION DEFINITION VIEW
 * @author jda1mbw
 */
@Named
@SessionScoped
public class AdminSurveySectionDefinitionView implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private ISurveySectionDefinitionFacade surveySectionDefinitionFacade;
	private SurveySectionDefinitionBo addedSurveySectionDefinition;
	@EJB
	private ISurveySectionTitleFacade surveySectionTitleFacade;
	@EJB
	private ISurveySectionStrategyFacade surveySectionStrategyFacade;
	private List<SurveySectionDefinitionBo> surveySectionDefinitions;
	private List<SurveySectionTitleBo> surveySectionTitles;
	private List<SurveySectionStrategyBo> surveySectionStrategies;

	/**
	 * Setup of the screen, loading the needed data
	 */
	@PostConstruct
	private void fillSurveySectionDefinitions() {
		surveySectionDefinitions = surveySectionDefinitionFacade.getAll();
	}

	/**
	 * Fill the survey section titles
	 */
	private void fillSurveySectionTitles() {
		surveySectionTitles = surveySectionTitleFacade.getAll();
	}

	/**
	 * Fill the survey section strategies
	 */
	private void fillSurveySectionStrategies() {
		surveySectionStrategies = surveySectionStrategyFacade.getAll();
	}

	/**
	 * Get a list of survey section definitions
	 * @return surveySectionDefinition
	 */
	public List<SurveySectionDefinitionBo> getSurveySectionDefinitions() {
		return surveySectionDefinitions;
	}

	/**
	 * Set a list of survey section definitions
	 * @param surveySectionDefinitions
	 */
	public void setSurveySectionDefinitions(List<SurveySectionDefinitionBo> surveySectionDefinitions) {
		this.surveySectionDefinitions = surveySectionDefinitions;
	}

	/**
	 * Get a list of survey section titles
	 * @return surveySectionTitles
	 */
	public List<SurveySectionTitleBo> getSurveySectionTitles() {
		return surveySectionTitles;
	}

	/**
	 * Set a list of survey section titles
	 * @param surveySectionTitles
	 */
	public void setSurveySectionTitles(List<SurveySectionTitleBo> surveySectionTitles) {
		this.surveySectionTitles = surveySectionTitles;
	}

	/**
	 * Get a list of survey section strategies
	 * @return surveySectionStrategies
	 */
	public List<SurveySectionStrategyBo> getSurveySectionStrategies() {
		return surveySectionStrategies;
	}

	/**
	 * Set a list of survey section strategies
	 * @param surveySectionStrategies
	 */
	public void setSurveySectionStrategies(List<SurveySectionStrategyBo> surveySectionStrategies) {
		this.surveySectionStrategies = surveySectionStrategies;
	}

	/**
	 * Get the added survey section definition
	 * @return addedSurveySectionDefinition
	 */
	public SurveySectionDefinitionBo getAddedSurveySectionDefinition() {
		return addedSurveySectionDefinition;
	}

	/**
	 * Set the added survey section definition
	 * @param addedSurveySectionDefinition
	 */
	public void setAddedSurveySectionDefinition(SurveySectionDefinitionBo addedSurveySectionDefinition) {
		fillSurveySectionStrategies();
		fillSurveySectionTitles();
		this.addedSurveySectionDefinition = addedSurveySectionDefinition;
	}

	/**
	 * Generate new survey section definition
	 */
	public void newSurveySectionDefinition() {
		addedSurveySectionDefinition = new SurveySectionDefinitionBo();
		fillSurveySectionTitles();
		fillSurveySectionStrategies();
	}
	
	/**
	 * Add a survey section definition
	 */
	public void addSurveySectionDefinition() {
		PrimeFaces pf = PrimeFaces.current();
		try {
			
			addedSurveySectionDefinition.setAdministratorCreated(true);
			surveySectionDefinitions.add(surveySectionDefinitionFacade.save(addedSurveySectionDefinition));
			pf.ajax().addCallbackParam("validationSuccess", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSuccess", false);
			FacesContext.getCurrentInstance().addMessage("addForm",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	/**
	 * Edit a survey section definition
	 */
	public void editSurveySectionDefinition() {

		PrimeFaces pf = PrimeFaces.current();
		SurveySectionDefinitionBo d = null;
		for (SurveySectionDefinitionBo definition : surveySectionDefinitions) {
			if (definition.getId() == addedSurveySectionDefinition.getId()) {
				definition.setSurveySectionTitle(addedSurveySectionDefinition.getSurveySectionTitle());
				definition.setSurveySectionStrategy(addedSurveySectionDefinition.getSurveySectionStrategy());
				d = definition;
			}
		}
		try {
			surveySectionDefinitionFacade.save(d);
			pf.ajax().addCallbackParam("validationSuccess", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSuccess", false);
			FacesContext.getCurrentInstance().addMessage("editForm",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	/**
	 * Delete a survey section definition
	 */
	public void deleteSurveySectionDefinition() {
		SurveySectionDefinitionBo d = null;
		for (SurveySectionDefinitionBo definition : surveySectionDefinitions) {
			if (definition.getId() == addedSurveySectionDefinition.getId()) {
				d = definition;
			}
		}
		try {
			surveySectionDefinitionFacade.delete(d);
			surveySectionDefinitions.remove(d);
		} catch (ValidationException e) {
			FacesContext.getCurrentInstance().addMessage("form",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
}
