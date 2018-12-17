package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import org.primefaces.PrimeFaces;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.SurveySectionTitleCantBeDeletedException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

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
	
	
	@PostConstruct 
	private void fillSurveySectionTitles() {
		surveySectionTitles = surveySectionTitleFacade.getAll();
	}
	
	public SurveySectionTitleBo getAddedSurveySectionTitle() {
		return addedSurveySectionTitle;
	}

	public void setAddedSurveySectionTitle(SurveySectionTitleBo addedSurveySectionTitle) {
		this.addedSurveySectionTitle = addedSurveySectionTitle;
	}

	public List<SurveySectionTitleBo> getSurveySectionTitles() {
		return surveySectionTitles;
	}

	public void setSurveySectionTitles(List<SurveySectionTitleBo> surveySectionTitles) {
		this.surveySectionTitles = surveySectionTitles;
	}

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
	
	public void newSurveySectionTitle() {
        addedSurveySectionTitle = new SurveySectionTitleBo();
    }
	
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
