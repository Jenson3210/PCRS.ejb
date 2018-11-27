package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;

@Named
@ViewScoped
public class AdminSurveySectionTitleView implements Serializable {

	private static final long serialVersionUID = 1L;
	private SurveySectionTitleBo addedSurveySectionTitle;
	private List<SurveySectionTitleBo> surveySectionTitles;
	@EJB
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
		SurveySectionTitleBo t = null;
		for (SurveySectionTitleBo title : surveySectionTitles) {
			if (title.getId() == addedSurveySectionTitle.getId()) {
				t = title;
			}
		}
		surveySectionTitles.remove(t);
		surveySectionTitleFacade.delete(t);
	}
}
