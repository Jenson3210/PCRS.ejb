package colruyt.pcrsejb.service.bl.surveys.surveySet;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.bl.IServiceBl;

@Local
public interface ISurveySetServiceBl extends IServiceBl<SurveySet> {
	SurveySet createSurveySetForUser(User convertToEntity, List<SurveySectionDefinitionImpl> convertToEntities);


}
