package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

/**
 * ADMIN SURVEY SECTION TITLE VIEW
 * @author jda1mbw
 */
@Named
@ViewScoped
public class AdminSurveySectionTitleView implements Serializable {

	private static final long serialVersionUID = 1L;
	private SurveySectionTitleBo addedSurveySectionTitle;
	private List<SurveySectionTitleBo> surveySectionTitles;
	@EJB
	private ISurveySectionTitleFacade surveySectionTitleFacade;
	@EJB
	private ISurveySectionDefinitionFacade surveySectionDefinitionFacade;
	
	/**
	 * Setup of the screen, loading the needed data
	 */
	@PostConstruct 
	private void fillSurveySectionTitles() {
		surveySectionTitles = surveySectionTitleFacade.getAll();
	}
	
	/**
	 * Get the added survey section title
	 * @return addedSurveySectionTitle
	 */
	public SurveySectionTitleBo getAddedSurveySectionTitle() {
		return addedSurveySectionTitle;
	}

	/**
	 * Set the added survey section title
	 * @param addedSurveySectionTitle
	 */
	public void setAddedSurveySectionTitle(SurveySectionTitleBo addedSurveySectionTitle) {
		this.addedSurveySectionTitle = addedSurveySectionTitle;
	}
	
	/**
	 * to check whether a Title is already used
	 * @param surveySectionStrategyBo
	 * @return
	 */
	public Boolean isSurveySectionTitleUsed(SurveySectionTitleBo addedSurveySectionTitle) {
		return surveySectionTitleFacade.isSurveySectionTitleUsed(addedSurveySectionTitle);
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
	 * Create a new survey section title
	 */
	public void newSurveySectionTitle() {
        addedSurveySectionTitle = new SurveySectionTitleBo();
    }
	
	/**
	 * Add a survey section title
	 */
	public void addSurveySectionTitle()
	{
		PrimeFaces pf = PrimeFaces.current();
		try {
			surveySectionTitles.add(surveySectionTitleFacade.save(addedSurveySectionTitle));
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("addForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
	
	/**
	 * Edit a survey section title
	 */
	public void editSurveySectionTitle() {
		PrimeFaces pf = PrimeFaces.current();
		SurveySectionTitleBo t = null;
		for (SurveySectionTitleBo title : surveySectionTitles) {
			if (title.getId() == addedSurveySectionTitle.getId()) {
				title.setTitle(addedSurveySectionTitle.getTitle());
				t = title;
			}
		}	
		try {
			surveySectionTitleFacade.save(t);
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("editForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		} 
	}
	
	/**
	 * Delete a survey section title
	 */
	public void deleteSurveySectionTitle()
	{
		SurveySectionTitleBo t = null;
		for (SurveySectionTitleBo title : surveySectionTitles) {
			if (title.getId() == addedSurveySectionTitle.getId()) {
				t = title;
			}
		}
		try {
			surveySectionTitleFacade.delete(t);
			surveySectionTitles.remove(t);
		} catch(ValidationException e)
		{
			FacesContext.getCurrentInstance().addMessage("form", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
}
