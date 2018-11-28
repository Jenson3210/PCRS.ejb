package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.util.List;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.service.dl.IDbService;

public interface ISurveySectionDefinitionServiceDl extends IDbService<SurveySectionDefinition> {

	List<SurveySectionDefinition> getSurveySectionDefinitionsForTitle(SurveySectionTitle t);

}
