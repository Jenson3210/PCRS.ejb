package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.CompetenceImplBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.competence.CompetenceImpl;

public class CompetenceImplConverter implements GenericConverter< CompetenceImpl,  CompetenceImplBo> {

	private CompetenceConverter competenceConverter = new CompetenceConverter();
	
	@Override
	public  CompetenceImpl convertToEntity( CompetenceImplBo bo) {
		CompetenceImpl entity = null;
		if (bo != null) {
			entity = new  CompetenceImpl();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getCompetenceDescription, entity::setCompetenceDescription);
			ConverterUtils.setIfNotNull(bo::getMinLevel, entity::setMinLevel);
			entity.setCompetence(competenceConverter.convertToEntity(bo.getCompetence()));
		} 
		return entity;
	}

	@Override
	public  CompetenceImplBo convertToBo( CompetenceImpl entity) {
		CompetenceImplBo bo = null;
		if (entity != null) {
			bo = new CompetenceImplBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getCompetenceDescription, bo::setCompetenceDescription);
			ConverterUtils.setIfNotNull(entity::getMinLevel, bo::setMinLevel);
			bo.setCompetence(competenceConverter.convertToBo(entity.getCompetence()));
		} 
		return bo;
	}

}