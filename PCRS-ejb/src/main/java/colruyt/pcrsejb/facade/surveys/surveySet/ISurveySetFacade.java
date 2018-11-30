package colruyt.pcrsejb.facade.surveys.surveySet;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.surveys.surveySet.SurveySetBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;
import colruyt.pcrsejb.facade.IFacade;


@Local
public interface ISurveySetFacade extends IFacade<SurveySetBo> {

	public Integer getPercentageCompleteForMemberSurvey(UserBo user);
	public Integer getPercentageCompleteForManagerSurvey(UserBo user);
	public Integer getPercentageCompleteForConsensusSurvey(UserBo user);  
	public List<SurveySectionDefinitionImplBo> getPossibleSections(UserBo user); 
	
	public SurveySetBo generateSurveySetFor(UserBo user);
	
	
}
