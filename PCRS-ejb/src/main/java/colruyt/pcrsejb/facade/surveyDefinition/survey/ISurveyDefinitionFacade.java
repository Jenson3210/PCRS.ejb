package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.IFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Local
public interface ISurveyDefinitionFacade extends IFacade<SurveyDefinitionBo> {
	
	List<SurveyDefinitionBo> getSurveyDefinitionsOfUser(UserBo user);
	UserBo getResponsible(SurveyDefinitionBo bo);
	
	SurveyDefinitionBo addSurveySectionDefinitionImpl(SurveyDefinitionBo surveyDefinition, SurveySectionDefinitionImplBo def) throws ValidationException;
	
	SurveyDefinitionBo removeSurveySectionDefinitionImpl(SurveyDefinitionBo surveyDefinition, SurveySectionDefinitionImplBo def) throws ValidationException;
	
	
}
