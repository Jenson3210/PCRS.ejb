package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.SurveySectionTitleFacade;

@Named
@SessionScoped
public class AdminSurveySectionTitleView implements Serializable {

	private static final long serialVersionUID = 1L;
	private SurveySectionTitleBo addedSurveySectionTitle;
	private List<SurveySectionTitleBo> surveySectionTitles;
	private ISurveySectionTitleFacade surveySectionTitleFacade;
	
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
	
}
