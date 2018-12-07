package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionTitleFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Named
@SessionScoped
public class AdminSurveySectionDefinitionView implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private ISurveySectionDefinitionFacade surveySectionDefinitionFacade;
	@EJB
	private ISurveySectionTitleFacade surveySectionTitleFacade;
	@EJB
	private ISurveySectionStrategyFacade surveySectionStrategyFacade;
	private List<SurveySectionDefinitionBo> surveySectionDefinitions;
	private List<SurveySectionTitleBo> surveySectionTitles;
	private List<SurveySectionStrategyBo> surveySectionStrategies;
	private SurveySectionDefinitionBo addedSurveySectionDefinition;

	@PostConstruct
	private void fillSurveySectionDefinitions() {
		surveySectionDefinitions = surveySectionDefinitionFacade.getAll();
	}

	private void fillSurveySectionTitles() {
		surveySectionTitles = surveySectionTitleFacade.getAll();
	}

	private void fillSurveySectionStrategies() {
		surveySectionStrategies = surveySectionStrategyFacade.getAll();
	}

	public List<SurveySectionDefinitionBo> getSurveySectionDefinitions() {
		return surveySectionDefinitions;
	}

	public void setSurveySectionDefinitions(List<SurveySectionDefinitionBo> surveySectionDefinitions) {
		this.surveySectionDefinitions = surveySectionDefinitions;
	}

	public List<SurveySectionTitleBo> getSurveySectionTitles() {
		return surveySectionTitles;
	}

	public void setSurveySectionTitles(List<SurveySectionTitleBo> surveySectionTitles) {
		this.surveySectionTitles = surveySectionTitles;
	}

	public List<SurveySectionStrategyBo> getSurveySectionStrategies() {
		return surveySectionStrategies;
	}

	public void setSurveySectionStrategies(List<SurveySectionStrategyBo> surveySectionStrategies) {
		this.surveySectionStrategies = surveySectionStrategies;
	}

	public SurveySectionDefinitionBo getAddedSurveySectionDefinition() {
		return addedSurveySectionDefinition;
	}

	public void setAddedSurveySectionDefinition(SurveySectionDefinitionBo addedSurveySectionDefinition) {
		fillSurveySectionStrategies();
		fillSurveySectionTitles();
		this.addedSurveySectionDefinition = addedSurveySectionDefinition;
	}

	public void addSurveySectionDefinition() {
		SurveySectionDefinitionBo ssd = surveySectionDefinitionFacade.save(addedSurveySectionDefinition);
		surveySectionDefinitions.add(ssd);
	}

	public void newSurveySectionDefinition() {
		addedSurveySectionDefinition = new SurveySectionDefinitionBo();
		fillSurveySectionTitles();
		fillSurveySectionStrategies();
	}

	public void editSurveySectionDefinition() {
		SurveySectionDefinitionBo d = null;

		for (SurveySectionDefinitionBo definition : surveySectionDefinitions) {
			if (definition.getId() == addedSurveySectionDefinition.getId()) {
				surveySectionDefinitionFacade.save(addedSurveySectionDefinition);
				d = definition;
			}
		}
		surveySectionDefinitionFacade.save(d);
	}

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
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}
}
