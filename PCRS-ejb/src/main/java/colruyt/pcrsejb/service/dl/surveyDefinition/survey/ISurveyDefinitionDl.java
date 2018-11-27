package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.service.dl.IDbService;

@Local
public interface ISurveyDefinitionDl extends IDbService<SurveyDefinition> {

}
