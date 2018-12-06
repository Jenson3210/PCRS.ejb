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
			ConverterUtils.setIfNotNull(bo::getEnergy, entity::setEnergy);
			ConverterUtils.setIfNotNull(bo::getLevel, entity::setLevel);
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
			ConverterUtils.setIfNotNull(entity::getEnergy, bo::setEnergy);
			ConverterUtils.setIfNotNull(entity::getLevel, bo::setLevel);
			bo.setCompetence(competenceImplConverter.convertToBo(entity.getCompetence()));
		}
		return bo;
	}
	
}
