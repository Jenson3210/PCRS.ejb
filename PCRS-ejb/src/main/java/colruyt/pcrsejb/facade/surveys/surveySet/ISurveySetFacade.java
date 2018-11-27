package colruyt.pcrsejb.facade.surveys.surveySet;

import javax.ejb.Remote;

import colruyt.pcrsejb.bo.surveys.surveySet.SurveySetBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.IFacade;


@Remote
public interface ISurveySetFacade extends IFacade<SurveySetBo> {

	public Integer getPercentageCompleteForMemberSurvey(UserBo user);
	public Integer getPercentageCompleteForManagerSurvey(UserBo user);
	public Integer getPercentageCompleteForConsensusSurvey(UserBo user);     
	
	
}
