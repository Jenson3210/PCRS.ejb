package colruyt.pcrsejb.facade.surveys.surveySet;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.bo.surveys.survey.SurveyBo;
import colruyt.pcrsejb.bo.surveys.survey.SurveyKindBo;
import colruyt.pcrsejb.bo.surveys.surveySet.SurveySetBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.IFacade;
import colruyt.pcrsejb.util.exceptions.NoSurveySetException;


@Local
public interface ISurveySetFacade extends IFacade<SurveySetBo> {

	public Integer getPercentageCompleteForMemberSurvey(UserBo user) throws NoSurveySetException;
	public Integer getPercentageCompleteForManagerSurvey(UserBo user) throws NoSurveySetException;
	public Integer getPercentageCompleteForConsensusSurvey(UserBo user) throws NoSurveySetException;  
	public List<SurveySectionDefinitionImplBo> getPossibleSections(UserBo user);
	public SurveySetBo generateSurveySetFor(List<SurveySectionDefinitionImplBo> sections);
	SurveyBo getSurveyForUser(UserBo user, SurveyKindBo surveyKind) throws NoSurveySetException;
	
}
