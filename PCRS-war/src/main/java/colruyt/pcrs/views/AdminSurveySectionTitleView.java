package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;

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
		surveySectionTitles.add(surveySectionTitleFacade.save(addedSurveySectionTitle));
	}
	
	public void newSurveySectionTitle() {
        addedSurveySectionTitle = new SurveySectionTitleBo();
    }
	
	public void editSurveySectionTitle() {
		SurveySectionTitleBo t = null;
		for (SurveySectionTitleBo title : surveySectionTitles) {
			if (title.getId() == addedSurveySectionTitle.getId()) {
				title.setTitle(addedSurveySectionTitle.getTitle());
				t = title;
			}
		}
		surveySectionTitleFacade.save(t); 
	}
	
	public void deleteSurveySectionTitle()
	{
		FacesContext context = FacesContext.getCurrentInstance();
		SurveySectionTitleBo t = null;
		for (SurveySectionTitleBo title : surveySectionTitles) {
			if (title.getId() == addedSurveySectionTitle.getId()) {
				t = title;
			}
		}
		List<SurveySectionDefinitionBo> listOfSurveySectionDefinitions = surveySectionDefinitionFacade.getSurveySectionDefinitionsForTitle(t);
		if(listOfSurveySectionDefinitions.size()==0)
		{
			surveySectionTitles.remove(t);
			surveySectionTitleFacade.delete(t);
		}
		else
		{
			context.addMessage(null, new FacesMessage("This title cannot be deleted, it is still used in one or more SurveySectionDefinitions."));
		}
	}
}
