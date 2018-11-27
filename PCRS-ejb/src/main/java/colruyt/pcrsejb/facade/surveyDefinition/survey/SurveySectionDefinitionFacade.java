package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;

@Stateless
public class SurveySectionDefinitionFacade implements Serializable,ISurveySectionDefinition {
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public SurveySectionDefinitionBo save(SurveySectionDefinitionBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SurveySectionDefinitionBo get(SurveySectionDefinitionBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveySectionDefinitionBo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SurveySectionDefinitionBo entityBo) {
		// TODO Auto-generated method stub
		
	}
	

	
	
}
