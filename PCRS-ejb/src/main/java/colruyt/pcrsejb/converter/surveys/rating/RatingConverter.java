package colruyt.pcrsejb.converter.surveys.rating;

import colruyt.pcrsejb.bo.surveys.rating.ConsensusRatingBo;
import colruyt.pcrsejb.bo.surveys.rating.RatingBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CompetenceImplConverter;
import colruyt.pcrsejb.entity.surveys.rating.ConsensusRating;
import colruyt.pcrsejb.entity.surveys.rating.Rating;

public class RatingConverter implements GenericConverter<Rating, RatingBo> {
	private CompetenceImplConverter competenceImplConverter = new CompetenceImplConverter();
	private EnergyOrInterestOptionTranslator energyOrInterestOptionTranslator = new EnergyOrInterestOptionTranslator();

	@Override
	public Rating convertToEntity(RatingBo bo) {
		Rating entity = null;
		if (bo != null) {
			if (bo instanceof ConsensusRatingBo) {
				entity = new ConsensusRating();
				ConverterUtils.setIfNotNull(((ConsensusRatingBo) bo)::getComment, ((ConsensusRating) entity)::setComment);
			}
			else {
				entity = new Rating();
			}
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getLevel, entity::setLevel);
			entity.setEnergy(energyOrInterestOptionTranslator.convertToEntity(bo.getEnergy()));
			entity.setInterest(energyOrInterestOptionTranslator.convertToEntity(bo.getInterest()));
			entity.setCompetence(competenceImplConverter.convertToEntity(bo.getCompetence()));
		}
		return entity;
	}

	@Override
	public RatingBo convertToBo(Rating entity) {
		RatingBo bo = null;
		if (entity != null) {
			if (entity instanceof ConsensusRating) {
				bo = new ConsensusRatingBo();
				ConverterUtils.setIfNotNull(((ConsensusRating) entity)::getComment, ((ConsensusRatingBo) bo)::setComment);
			}
			else {
				bo = new RatingBo();
			}
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getLevel, bo::setLevel);
			bo.setEnergy(energyOrInterestOptionTranslator.convertToBo(entity.getEnergy()));
			bo.setInterest(energyOrInterestOptionTranslator.convertToBo(entity.getInterest()));
			bo.setCompetence(competenceImplConverter.convertToBo(entity.getCompetence()));
		}
		return bo;
	}
	
}
