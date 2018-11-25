package colruyt.pcrsejb.converter.surveys.surveySet;

import colruyt.pcrsejb.bo.surveys.surveySet.SurveySetBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.surveys.survey.SurveyConverter;
import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;

public class SurveySetConverter implements GenericConverter<SurveySet, SurveySetBo>{

	private SurveyConverter surveyConverter = new SurveyConverter();
	
	@Override
	public SurveySet convertToEntity(SurveySetBo bo) {
		SurveySet entity = null;
		if (bo != null) {
			entity = new SurveySet();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getSurveyYear, entity::setSurveyYear);
			entity.setSurveyList(surveyConverter.convertToEntities(bo.getSurveyList()));
		}
		return entity;
	}

	@Override
	public SurveySetBo convertToBo(SurveySet entity) {
		SurveySetBo bo = null;
		if (entity != null) {
			bo = new SurveySetBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getSurveyYear, bo::setSurveyYear);
			bo.setSurveyList(surveyConverter.convertToBos(entity.getSurveyList()));		
		}
		return bo;
	}
	
	
}
