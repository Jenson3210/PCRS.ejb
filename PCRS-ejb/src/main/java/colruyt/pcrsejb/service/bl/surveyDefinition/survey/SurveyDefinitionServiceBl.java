package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.surveyDefinition.survey.ISurveyDefinitionDl;

@Stateless
public class SurveyDefinitionServiceBl implements ISurveyDefinitionServiceBl {
	
	@EJB
	private ISurveyDefinitionDl surveyDefinitionDl;

	
	@Override
	public SurveyDefinition save(SurveyDefinition element) {
		return surveyDefinitionDl.save(element);
	}

	@Override
	public SurveyDefinition get(SurveyDefinition element) {
		return surveyDefinitionDl.get(element);
	}

	@Override
	public List<SurveyDefinition> getAll() {
		return surveyDefinitionDl.getAll();
	}

	@Override
	public void delete(SurveyDefinition element) {
		surveyDefinitionDl.delete(element);
	}

	@Override
	public List<SurveyDefinition> getSurveyDefinitionsOfUser(User user) {
		
		return surveyDefinitionDl.getSurveyDefinitionsOfUser(user);
	}

	@Override
	public User getResponsible(SurveyDefinition surveyDefinition) {
		return surveyDefinitionDl.getResponsible(surveyDefinition);
	}
	
	
}
