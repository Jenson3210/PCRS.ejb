package colruyt.pcrsejb.facade.surveys.surveySet;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveys.surveySet.SurveySetBo;
import colruyt.pcrsejb.bo.user.UserBo;

@Stateless
public class SurveySetFacade implements Serializable,ISurveySetFacade{
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public SurveySetBo save(SurveySetBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SurveySetBo get(SurveySetBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveySetBo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SurveySetBo entityBo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getPercentageCompleteForMemberSurvey(UserBo user) {
		// TODO Auto-generated method stub
		return 50;
	}

	@Override
	public Integer getPercentageCompleteForManagerSurvey(UserBo user) {
		// TODO Auto-generated method stub
		return 40;
	}

	@Override
	public Integer getPercentageCompleteForConsensusSurvey(UserBo user) {
		// TODO Auto-generated method stub
		return 70;
	}
}
