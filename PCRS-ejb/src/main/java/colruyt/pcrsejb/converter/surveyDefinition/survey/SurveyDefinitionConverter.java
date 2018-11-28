package colruyt.pcrsejb.converter.surveyDefinition.survey;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;

public class SurveyDefinitionConverter implements GenericConverter<SurveyDefinition, SurveyDefinitionBo> {

	private UserConverter userConverter = new UserConverter();
	private SurveySectionDefinitionImplConverter surveySectionDefinitionImplConverter = new SurveySectionDefinitionImplConverter();
	
	@Override
	public SurveyDefinition convertToEntity(SurveyDefinitionBo bo) {
		SurveyDefinition entity = null;
		if (bo != null) {
			entity = new SurveyDefinition();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getName, entity::setName);
			entity.setSurveySections(surveySectionDefinitionImplConverter.convertToEntities(bo.getSurveySections()));
			return entity;
		}
		return entity;
	}

	@Override
	public SurveyDefinitionBo convertToBo(SurveyDefinition entity) {
		SurveyDefinitionBo bo = null;
		if (entity != null) {
			bo = new SurveyDefinitionBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getName, bo::setName);
			bo.setSurveySections(surveySectionDefinitionImplConverter.convertToBos(entity.getSurveySections()));
		}
		return bo;
	}
	
}
