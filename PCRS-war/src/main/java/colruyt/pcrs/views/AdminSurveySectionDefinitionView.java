package colruyt.pcrs.views;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionFacade;

@Named
@SessionScoped
public class AdminSurveySectionDefinitionView implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ISurveySectionDefinitionFacade surveySectionDefinitionFacade;
	@EJB
	private ISurveySectionStrategyFacade surveySectionStrategyFacade;
	
	private List<SurveySectionDefinitionBo> surveySectionDefinitions;
	private List<SurveySectionStrategyBo> surveySectionStrategies;

	private SurveySectionDefinitionBo addedSurveySectionDefinition;

	@PostConstruct
	private void fillSurveySectionDefinitions() {
		surveySectionDefinitions = surveySectionDefinitionFacade.getAll();
	}
	
	public void getSurveySectionStrategies() {
		surveySectionStrategies = surveySectionStrategyFacade.getAll();
	}
	
	public void setSurveySectionStrategies(List<SurveySectionStrategyBo> surveySectionStrategies) {
		this.surveySectionStrategies = surveySectionStrategies;
	}

	public List<SurveySectionDefinitionBo> getSurveySectionDefinitions() {
		return surveySectionDefinitions;
	}

	public void setSurveySectionDefinitions(List<SurveySectionDefinitionBo> surveySectionDefinitions) {
		this.surveySectionDefinitions = surveySectionDefinitions;
	}

	public SurveySectionDefinitionBo getAddedSurveySectionDefinition() {
		return addedSurveySectionDefinition;
	}

	public void setAddedSurveySectionDefinition(SurveySectionDefinitionBo addedSurveySectionDefinition) {
		this.addedSurveySectionDefinition = addedSurveySectionDefinition;
	}

	public void addSurveySectionDefinition() {
		surveySectionDefinitions.add(surveySectionDefinitionFacade.save(addedSurveySectionDefinition));
	}

	public void newSurveySectionDefinition() {
		addedSurveySectionDefinition = new SurveySectionDefinitionBo();
	}

}
