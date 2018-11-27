package colruyt.pcrsejb.converter.surveyDefinition.survey;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionRequirementLevelBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionRequirementLevel;

public class SurveySectionDefinitionImplConverter implements GenericConverter<SurveySectionDefinitionImpl, SurveySectionDefinitionImplBo> {

	private SurveySectionDefinitionConverter surveySectionDefinitionConverter = new SurveySectionDefinitionConverter();
	
	@Override
	public SurveySectionDefinitionImpl convertToEntity(SurveySectionDefinitionImplBo bo) {
		SurveySectionDefinitionImpl entity = null;
		if (bo != null) {
			entity = new SurveySectionDefinitionImpl();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			switch (bo.getSurveySectionRequirementLevelBo()) {
			case Optional:
				entity.setSurveySectionRequirementLevel(SurveySectionRequirementLevel.Optional);
				break;
			case Expected:
				entity.setSurveySectionRequirementLevel(SurveySectionRequirementLevel.Expected);
				break;
			case Obligated:
				entity.setSurveySectionRequirementLevel(SurveySectionRequirementLevel.Obligated);
				break;
			}
			entity.setSurveySectionDefinition(surveySectionDefinitionConverter.convertToEntity(bo.getSurveySectionDefinitionBo()));
		}
		return entity;
	}

	@Override
	public SurveySectionDefinitionImplBo convertToBo(SurveySectionDefinitionImpl entity) {
		SurveySectionDefinitionImplBo bo = null;
		if (entity != null) {
			bo = new SurveySectionDefinitionImplBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			switch (entity.getSurveySectionRequirementLevel()) {
			case Optional:
				bo.setSurveySectionRequirementLevelBo(SurveySectionRequirementLevelBo.Optional);
				break;
			case Expected:
				bo.setSurveySectionRequirementLevelBo(SurveySectionRequirementLevelBo.Expected);
				break;
			case Obligated:
				bo.setSurveySectionRequirementLevelBo(SurveySectionRequirementLevelBo.Obligated);
				break;
			}
			bo.setSurveySectionDefinitionBo(surveySectionDefinitionConverter.convertToBo(entity.getSurveySectionDefinition()));
		}
		return bo;
	}

	
	
	

}
