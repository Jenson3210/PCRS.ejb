package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.IFacade;

@Local
public interface ISurveyDefinitionFacade extends IFacade<SurveyDefinitionBo> {
	
	
	List<SurveyDefinitionBo> getSurveyDefinitionsOfUser(UserBo user);

}
