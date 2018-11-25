package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.competence.Competence;

public class CompetenceConverter implements GenericConverter<Competence, CompetenceBo> {
	private CompetenceLevelConverter competenceLevelConverter = new CompetenceLevelConverter();

	@Override
	public Competence convertToEntity(CompetenceBo bo) {
		Competence entity = null;
		if (bo != null) {
			entity = new Competence();
			ConverterUtils.setIfNotNull(bo::getCompetenceDescription, entity::setCompetenceDescription);
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getName, entity::setName);
			entity.setCompetenceLevels(competenceLevelConverter.convertToEntities(bo.getCompetenceLevels()));
		}
		return entity;
	}

	@Override
	public CompetenceBo convertToBo(Competence entity) {
		CompetenceBo bo = null;
		if (entity != null) {
			bo = new CompetenceBo();
			ConverterUtils.setIfNotNull(entity::getCompetenceDescription, bo::setCompetenceDescription);
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getName, bo::setName);
			bo.setCompetenceLevels(competenceLevelConverter.convertToBos(entity.getCompetenceLevels()));
		}
		return bo;
	}
    
}
