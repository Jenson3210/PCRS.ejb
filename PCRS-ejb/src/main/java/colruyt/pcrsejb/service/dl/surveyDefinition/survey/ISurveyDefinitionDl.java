package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.IDbService;

@Local
public interface ISurveyDefinitionDl extends IDbService<SurveyDefinition> {

	
	public List<SurveyDefinition> getSurveyDefinitionsOfUser(User user);
}
