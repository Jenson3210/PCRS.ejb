package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionRequirementLevel;
import colruyt.pcrsejb.service.bl.IServiceBl;

@Local
public interface ISurveySectionDefinitionServiceBl extends IServiceBl<SurveySectionDefinition> {

	SurveySectionDefinition getSurveySectionTitle(SurveySectionTitleBo surveySectionTitle);
	SurveySectionDefinition getSurveySectionStrategy(SurveySectionStrategy surveySectionStrategy);
	SurveySectionDefinition getSurveySectionRequirementLevel(SurveySectionRequirementLevel surveySectionRequirementLevel);
	List<SurveySectionDefinition> getSurveySectionCompetences();

}
