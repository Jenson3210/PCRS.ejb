package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.CompetenceLevelBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.competence.CompetenceLevel;

public class CompetenceLevelConverter implements GenericConverter<CompetenceLevel, CompetenceLevelBo> {

	@Override
	public CompetenceLevel convertToEntity(CompetenceLevelBo bo) {
		CompetenceLevel entity = null;
		if (bo != null) {
			entity = new CompetenceLevel();
			ConverterUtils.setIfNotNull(bo::getDescription, entity::setDescription);
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getOrderLevel, entity::setOrderLevel);
		} 
		return entity;
	}

	@Override
	public CompetenceLevelBo convertToBo(CompetenceLevel entity) {
		CompetenceLevelBo bo = null;
		if (entity != null) {
			bo = new CompetenceLevelBo();
			ConverterUtils.setIfNotNull(entity::getDescription, bo::setDescription);
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getOrderLevel, bo::setOrderLevel);
		} 
		return bo;
	}

}
