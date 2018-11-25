package colruyt.pcrsejb.converter.surveyDefinition.survey;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;

public class SurveySectionTitleConverter implements GenericConverter<SurveySectionTitle, SurveySectionTitleBo> {

	@Override
	public SurveySectionTitle convertToEntity(SurveySectionTitleBo bo) {
		SurveySectionTitle entity = null;
		if (bo != null) {
			entity = new SurveySectionTitle();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getTitle, entity::setTitle);
		}
		return entity;
	}

	@Override
	public SurveySectionTitleBo convertToBo(SurveySectionTitle entity) {
		SurveySectionTitleBo bo = null;
		if (entity != null) {
			bo = new SurveySectionTitleBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getTitle, bo::setTitle);
			
		}
		return bo;
	}
	
}
