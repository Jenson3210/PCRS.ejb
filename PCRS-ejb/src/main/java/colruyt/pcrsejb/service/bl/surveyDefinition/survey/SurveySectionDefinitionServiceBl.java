package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionRequirementLevel;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.service.dl.surveyDefinition.survey.ISurveySectionDefinitionServiceDl;

@Stateless
public class SurveySectionDefinitionServiceBl implements ISurveySectionDefinitionServiceBl {
	
	@EJB
	private ISurveySectionDefinitionServiceDl surveySectionDefinitionDb;

	@Override
	public SurveySectionDefinition save(SurveySectionDefinition surveySectionDefinition) {
		return surveySectionDefinitionDb.save(surveySectionDefinition);
	}

	@Override
	public SurveySectionDefinition get(SurveySectionDefinition surveySectionDefinition) {
		return surveySectionDefinitionDb.get(surveySectionDefinition);
	}

	@Override
	public List<SurveySectionDefinition> getAll() {
		return surveySectionDefinitionDb.getAll();
	}

	@Override
	public void delete(SurveySectionDefinition surveySectionDefinition) {
		surveySectionDefinitionDb.delete(surveySectionDefinition);
	}

	@Override
	public SurveySectionDefinition getSurveySectionTitle(SurveySectionTitle surveySectionTitle) {
		return surveySectionDefinitionDb.getSurveySectionTitle(surveySectionTitle);
	}

	@Override
	public SurveySectionDefinition getSurveySectionStrategy(SurveySectionStrategy surveySectionStrategy) {
		return surveySectionDefinitionDb.getSurveySectionStrategy(surveySectionStrategy);
	}

	@Override
	public SurveySectionDefinition getSurveySectionRequirementLevel(SurveySectionRequirementLevel surveySectionRequirementLevel) {
		return surveySectionDefinitionDb.getSurveySectionRequirementLevel(surveySectionRequirementLevel);
	}

	@Override
	public List<SurveySectionDefinition> getSurveySectionCompetences() {
		// TODO Auto-generated method stub
		return null;
	}
}
