package colruyt.pcrsejb.converter.surveyDefinition.survey;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CompetenceImplConverter;
import colruyt.pcrsejb.converter.surveyDefinition.strategy.SurveySectionStrategyConverter;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;

public class SurveySectionDefinitionConverter implements GenericConverter<SurveySectionDefinition, SurveySectionDefinitionBo> {

	private SurveySectionStrategyConverter surveySectionStrategyConverter = new SurveySectionStrategyConverter();
	private SurveySectionTitleConverter surveySectionTitleConverter = new SurveySectionTitleConverter();
	private CompetenceImplConverter competenceImplConverter = new CompetenceImplConverter();
	
	@Override
	public SurveySectionDefinition convertToEntity(SurveySectionDefinitionBo bo) {
		SurveySectionDefinition entity = null;
		if (bo != null) {
			entity = new SurveySectionDefinition();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getAdministratorCreated, entity::setAdministratorCreated);
			entity.setSurveySectionTitle(surveySectionTitleConverter.convertToEntity(bo.getSurveySectionTitle()));
			entity.setSurveySectionStrategy(surveySectionStrategyConverter.convertToEntity(bo.getSurveySectionStrategy()));
			entity.setSurveySectionCompetences(competenceImplConverter.convertToEntities(bo.getSurveySectionCompetences()));
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
			bo.setSurveySectionTitle(surveySectionTitleConverter.convertToBo(entity.getSurveySectionTitle()));
			bo.setSurveySectionStrategy(surveySectionStrategyConverter.convertToBo(entity.getSurveySectionStrategy()));
			bo.setSurveySectionCompetences(competenceImplConverter.convertToBos(entity.getSurveySectionCompetences()));
		}
		return bo;
	}

}
