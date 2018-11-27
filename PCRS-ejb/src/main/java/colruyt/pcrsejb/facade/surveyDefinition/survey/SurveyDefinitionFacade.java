package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveyDefinitionConverter;
import colruyt.pcrsejb.service.bl.surveyDefinition.survey.ISurveyDefinitionServiceBl;

@Stateless
public class SurveyDefinitionFacade implements Serializable, ISurveyDefinitionFacade {
	
	
	private static final long serialVersionUID = 1L;

	@EJB
	private ISurveyDefinitionServiceBl surveyDefinitionServiceBl;
	private SurveyDefinitionConverter surveyDefinitionConverter = new SurveyDefinitionConverter();
	
	@Override
	public SurveyDefinitionBo save(SurveyDefinitionBo entityBo) {
		return surveyDefinitionConverter.convertToBo(surveyDefinitionServiceBl.save(surveyDefinitionConverter.convertToEntity(entityBo)));
	}

	@Override
	public SurveyDefinitionBo get(SurveyDefinitionBo entityBo) {
		return surveyDefinitionConverter.convertToBo(surveyDefinitionServiceBl.get(surveyDefinitionConverter.convertToEntity(entityBo)));
	}

	@Override
	public List<SurveyDefinitionBo> getAll() {
		return surveyDefinitionConverter.convertToBos(surveyDefinitionServiceBl.getAll());
	}

	@Override
	public void delete(SurveyDefinitionBo entityBo) {
		surveyDefinitionServiceBl.delete(surveyDefinitionConverter.convertToEntity(entityBo));
	}
}
