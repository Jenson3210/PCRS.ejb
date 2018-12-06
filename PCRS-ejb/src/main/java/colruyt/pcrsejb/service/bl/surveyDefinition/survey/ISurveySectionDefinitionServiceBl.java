package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.service.bl.IServiceBl;

@Local
public interface ISurveySectionDefinitionServiceBl extends IServiceBl<SurveySectionDefinition> {

	List<SurveySectionDefinition> getSurveySectionDefinitionsForTitle(SurveySectionTitle t);

	
	
}
