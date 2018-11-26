package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.facade.IFacade;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionRequirementLevel;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;

@Local
public interface ISurveySectionDefinitionFacade extends IFacade<SurveySectionDefinitionBo> {
	
	SurveySectionDefinitionBo getSurveySectionTitle(SurveySectionTitle surveySectionTitle);
	SurveySectionDefinitionBo getSurveySectionStrategy(SurveySectionStrategy surveySectionStrategy);
	SurveySectionDefinitionBo getSurveySectionRequirementLevel(SurveySectionRequirementLevel surveySectionRequirementLevel);
	List<SurveySectionDefinitionBo> getSurveySectionCompetences();
}
