package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.bl.IServiceBl;

@Local
public interface ISurveyDefinitionServiceBl extends IServiceBl<SurveyDefinition> {
	
	public List<SurveyDefinition> getSurveyDefinitionsOfUser(User user) ;
	public User getResponsible(SurveyDefinition surveyDefinition);

}
