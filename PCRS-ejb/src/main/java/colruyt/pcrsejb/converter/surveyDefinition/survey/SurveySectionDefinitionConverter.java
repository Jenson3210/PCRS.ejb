package colruyt.pcrsejb.converter.surveyDefinition.survey;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionRequirementLevelBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CompetenceConverter;
import colruyt.pcrsejb.converter.surveyDefinition.strategy.SurveySectionStrategyConverter;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionRequirementLevel;

public class SurveySectionDefinitionConverter implements GenericConverter<SurveySectionDefinition, SurveySectionDefinitionBo> {

	private SurveySectionStrategyConverter surveySectionStrategyConverter = new SurveySectionStrategyConverter();
	private SurveySectionTitleConverter surveySectionTitleConverter = new SurveySectionTitleConverter();
	private CompetenceConverter competenceConverter = new CompetenceConverter();
	
	@Override
	public SurveySectionDefinition convertToEntity(SurveySectionDefinitionBo bo) {
		SurveySectionDefinition entity = null;
		if (bo != null) {
			entity = new SurveySectionDefinition();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getAdministratorCreated, entity::setAdministratorCreated);
			switch (bo.getSurveySectionRequirementLevel()) {
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
			entity.setSurveySectionTitle(surveySectionTitleConverter.convertToEntity(bo.getSurveySectionTitle()));
			entity.setSurveySectionStrategy(surveySectionStrategyConverter.convertToEntity(bo.getSurveySectionStrategy()));
			entity.setSurveySectionCompetences(competenceConverter.convertToEntities(bo.getSurveySectionCompetences()));
		}
		return entity;
	}

	@Override
	public SurveySectionDefinitionBo convertToBo(SurveySectionDefinition entity) {
		SurveySectionDefinitionBo bo = null;
		if (entity != null) {
			bo = new SurveySectionDefinitionBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getAdministratorCreated, bo::setAdministratorCreated);
			switch (entity.getSurveySectionRequirementLevel()) {
			case OPTIONAL:
				bo.setSurveySectionRequirementLevel(SurveySectionRequirementLevelBo.OPTIONAL);
				break;
			case EXPECTED:
				bo.setSurveySectionRequirementLevel(SurveySectionRequirementLevelBo.EXPECTED);
				break;
			case OBLIGATED:
				bo.setSurveySectionRequirementLevel(SurveySectionRequirementLevelBo.OBLIGATED);
				break;
			}
			bo.setSurveySectionTitle(surveySectionTitleConverter.convertToBo(entity.getSurveySectionTitle()));
			bo.setSurveySectionStrategy(surveySectionStrategyConverter.convertToBo(entity.getSurveySectionStrategy()));
			bo.setSurveySectionCompetences(competenceConverter.convertToBos(entity.getSurveySectionCompetences()));
		}
		return bo;
	}

}
