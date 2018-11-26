package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;

@Stateless
public class SurveyDefinitionFacade implements Serializable, ISurveyDefinitionFacade {
	
	
	private static final long serialVersionUID = 1L;

	
	@Override
	public SurveyDefinitionBo save(SurveyDefinitionBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SurveyDefinitionBo get(SurveyDefinitionBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveyDefinitionBo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SurveyDefinitionBo entityBo) {
		// TODO Auto-generated method stub
		
	}
}
