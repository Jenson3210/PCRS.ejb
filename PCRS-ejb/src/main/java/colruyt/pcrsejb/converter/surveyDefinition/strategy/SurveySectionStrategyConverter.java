package colruyt.pcrsejb.converter.surveyDefinition.strategy;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;

public class SurveySectionStrategyConverter implements GenericConverter<SurveySectionStrategy, SurveySectionStrategyBo>{

	@Override
	public SurveySectionStrategy convertToEntity(SurveySectionStrategyBo bo) {
		SurveySectionStrategy entity = null;
		if (bo != null) {
			entity = new SurveySectionStrategy();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getName, entity::setName);
			ConverterUtils.setIfNotNull(bo::getAmountOfLevels, entity::setAmountOfLevels);
			ConverterUtils.setIfNotNull(bo::getDescriptionRequired, entity::setDescriptionRequired);
			ConverterUtils.setIfNotNull(bo::getEnergyRated, entity::setEnergyRated);
			ConverterUtils.setIfNotNull(bo::getFlexibleDescription, entity::setFlexibleDescription);
			ConverterUtils.setIfNotNull(bo::getHasMinimumLevel, entity::setHasMinimumLevel);
			ConverterUtils.setIfNotNull(bo::getInterestRated, entity::setInterestRated);
		}
		return entity;
	}

	@Override
	public SurveySectionStrategyBo convertToBo(SurveySectionStrategy entity) {
		SurveySectionStrategyBo bo = null;
		if (entity != null) {
			bo = new SurveySectionStrategyBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getName, bo::setName);
			ConverterUtils.setIfNotNull(entity::getAmountOfLevels, bo::setAmountOfLevels);
			ConverterUtils.setIfNotNull(entity::getDescriptionRequired, bo::setDescriptionRequired);
			ConverterUtils.setIfNotNull(entity::getEnergyRated, bo::setEnergyRated);
			ConverterUtils.setIfNotNull(entity::getFlexibleDescription, bo::setFlexibleDescription);
			ConverterUtils.setIfNotNull(entity::getHasMinimumLevel, bo::setHasMinimumLevel);
			ConverterUtils.setIfNotNull(entity::getInterestRated, bo::setInterestRated);
			
		}
		return bo;
	}
	
	
}
