package colruyt.pcrsejb.service.dl.surveys.survey;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.surveys.survey.Survey;
import colruyt.pcrsejb.service.dl.IDbService;

@Local
public interface ISurveyServiceDl extends IDbService<Survey> {

}
