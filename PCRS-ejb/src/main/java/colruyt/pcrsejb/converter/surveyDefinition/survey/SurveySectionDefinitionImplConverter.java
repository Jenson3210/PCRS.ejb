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
			if (bo.getSurveySectionRequirementLevelBo() != null) {
				switch (bo.getSurveySectionRequirementLevelBo()) {
				case OPTIONAL:
					entity.setSurveySectionRequirementLevel(SurveySectionRequirementLevel.OPTIONAL);
					break;
				case EXPECTED:
					entity.setSurveySectionRequirementLevel(SurveySectionRequirementLevel.EXPECTED);
					break;
				case OBLIGATED:
					entity.setSurveySectionRequirementLevel(SurveySectionRequirementLevel.OBLIGATED);
					break;
				}
			}
			if (bo.getSurveySectionDefinitionBo() != null) {
				entity.setSurveySectionDefinition(surveySectionDefinitionConverter.convertToEntity(bo.getSurveySectionDefinitionBo()));
			}
		}
		return entity;
	}

	@Override
	public SurveySectionDefinitionImplBo convertToBo(SurveySectionDefinitionImpl entity) {
		SurveySectionDefinitionImplBo bo = null;
		if (entity != null) {
			bo = new SurveySectionDefinitionImplBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			if (null != entity.getSurveySectionRequirementLevel()) {
				switch (entity.getSurveySectionRequirementLevel()) {
				case OPTIONAL:
					bo.setSurveySectionRequirementLevelBo(SurveySectionRequirementLevelBo.OPTIONAL);
					break;
				case EXPECTED:
					bo.setSurveySectionRequirementLevelBo(SurveySectionRequirementLevelBo.EXPECTED);
					break;
				case OBLIGATED:
					bo.setSurveySectionRequirementLevelBo(SurveySectionRequirementLevelBo.OBLIGATED);
					break;
				}
			}
			if (null != entity.getSurveySectionDefinition()) {
				bo.setSurveySectionDefinitionBo(surveySectionDefinitionConverter.convertToBo(entity.getSurveySectionDefinition()));
			}
		}
		return bo;
	}

	
	
	

}
