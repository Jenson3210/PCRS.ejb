package colruyt.pcrsejb.service.bl.surveys.surveySet;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.entity.surveys.survey.Survey;
import colruyt.pcrsejb.entity.surveys.survey.SurveyKind;
import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.bl.IServiceBl;
import colruyt.pcrsejb.util.exceptions.NoSurveySetException;

@Local
public interface ISurveySetServiceBl extends IServiceBl<SurveySet> {
	SurveySet createSurveySetForUser(List<SurveySectionDefinitionImpl> convertToEntities);
	public Integer getPercentageCompleteForMemberSurvey(User user) throws NoSurveySetException ;
	public Integer getPercentageCompleteForManagerSurvey(User user) throws NoSurveySetException;
	public Integer getPercentageCompleteForConsensusSurvey(User user) throws NoSurveySetException;
	Survey getSurveyForUser(User convertToEntity, SurveyKind surveyKind) throws NoSurveySetException;
	
	
	
	

}
