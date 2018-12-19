package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.bl.IServiceBl;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.SurveySectionDefinitionImplAlreadyUsedException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Local
public interface ISurveyDefinitionServiceBl extends IServiceBl<SurveyDefinition> {
	
	public List<SurveyDefinition> getSurveyDefinitionsOfUser(User user) ;
	public User getResponsible(SurveyDefinition surveyDefinition);
	void validateSectionDefinitionImpl(SurveyDefinitionBo surveyDefinition, SurveySectionDefinitionImplBo def) throws ValidationException;

}
