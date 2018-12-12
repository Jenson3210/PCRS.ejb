package colruyt.pcrsejb.converter.surveys.survey;

import colruyt.pcrsejb.bo.surveys.survey.SurveyBo;
import colruyt.pcrsejb.bo.surveys.survey.SurveyKindBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.surveys.survey.Survey;
import colruyt.pcrsejb.entity.surveys.survey.SurveyKind;

public class SurveyConverter implements GenericConverter<Survey, SurveyBo> {

	private SurveySectionConverter surveySectionConverter = new SurveySectionConverter();
	private SurveyKindTranslator surveyKindTranslator = new SurveyKindTranslator();

	@Override
	public Survey convertToEntity(SurveyBo bo) {
		Survey entity = null;
		if (bo != null) {
			entity = new Survey();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getDateCompleted, entity::setDateCompleted);
			entity.setSurveyKind(surveyKindTranslator.convertToEntity(bo.getSurveyKind()));
			entity.setSurveySections(surveySectionConverter.convertToEntities(bo.getSurveySections()));
		} 
		return entity;
	}

	@Override
	public SurveyBo convertToBo(Survey entity) {
		SurveyBo bo = null;
		if (entity != null) {
			bo = new SurveyBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getDateCompleted, bo::setDateCompleted);
			bo.setSurveyKind(surveyKindTranslator.convertToBo(entity.getSurveyKind()));
			bo.setSurveySections(surveySectionConverter.convertToBos(entity.getSurveySections()));
		} 
		return bo;
	}

}
