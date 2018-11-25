package colruyt.pcrsejb.converter.surveys.survey;

import colruyt.pcrsejb.bo.surveys.survey.SurveySectionBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionDefinitionConverter;
import colruyt.pcrsejb.converter.surveys.rating.RatingConverter;
import colruyt.pcrsejb.entity.surveys.survey.SurveySection;

public class SurveySectionConverter implements GenericConverter<SurveySection, SurveySectionBo> {

	private RatingConverter ratingConverter = new RatingConverter();
	private SurveySectionDefinitionConverter surveySectionDefinitionConverter = new SurveySectionDefinitionConverter();
	
	@Override
	public SurveySection convertToEntity(SurveySectionBo bo) {
		SurveySection entity = null;
		if (bo != null) {
			entity = new SurveySection();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			entity.setRatings(ratingConverter.convertToEntities(bo.getRatings()));
			entity.setSurveySectionDefinition(surveySectionDefinitionConverter.convertToEntity(bo.getSurveySectionDefinition()));
		} 
		return entity;
	}

	@Override
	public SurveySectionBo convertToBo(SurveySection entity) {
		SurveySectionBo bo = null;
		if (entity != null) {
			bo = new SurveySectionBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			bo.setRatings(ratingConverter.convertToBos(entity.getRatings()));
			bo.setSurveySectionDefinition(surveySectionDefinitionConverter.convertToBo(entity.getSurveySectionDefinition()));
		}
		return bo;
	}
	
}
