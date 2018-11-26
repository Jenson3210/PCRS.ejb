package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionRequirementLevel;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.service.dl.IDbService;

@Local
public interface ISurveySectionDefinitionServiceDl extends IDbService<SurveySectionDefinition> {
	
	SurveySectionDefinition getSurveySectionTitle(SurveySectionTitle surveySectionTitle);
	SurveySectionDefinition getSurveySectionStrategy(SurveySectionStrategy surveySectionStrategy);
	SurveySectionDefinition getSurveySectionRequirementLevel(SurveySectionRequirementLevel surveySectionRequirementLevel);
	List<SurveySectionDefinition> getSurveySectionCompetences();
}
