package colruyt.pcrsejb.converter.surveys.survey;

import colruyt.pcrsejb.bo.surveys.survey.SurveyBo;
import colruyt.pcrsejb.bo.surveys.survey.SurveyKindBo;
import colruyt.pcrsejb.converter.ConverterUtils;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.surveys.survey.Survey;
import colruyt.pcrsejb.entity.surveys.survey.SurveyKind;

public class SurveyConverter implements GenericConverter<Survey, SurveyBo> {

	private SurveySectionConverter surveySectionConverter = new SurveySectionConverter();

	@Override
	public Survey convertToEntity(SurveyBo bo) {
		Survey entity = null;
		if (bo != null) {
			entity = new Survey();
			ConverterUtils.setIfNotNull(bo::getId, entity::setId);
			ConverterUtils.setIfNotNull(bo::getDateCompleted, entity::setDateCompleted);
			switch (bo.getSurveyKind()) {
				case TeamMember:
					entity.setSurveyKind(SurveyKind.TeamMember);
					break;
				case TeamManager:
					entity.setSurveyKind(SurveyKind.TeamManager);
					break;
				case Consensus:
					entity.setSurveyKind(SurveyKind.Consensus);
					break;
			}
			entity.setSurveySections(surveySectionConverter.convertToEntities(bo.getSurveySections()));
		} 
		return entity;
	}

	@Override
	public SurveyBo convertToBo(Survey entity) {
		SurveyBo bo = null;
		if (entity != null) {
			bo = new SurveyBo();
			ConverterUtils.setIfNotNull(entity::getId, bo::setId);
			ConverterUtils.setIfNotNull(entity::getDateCompleted, bo::setDateCompleted);
			switch (entity.getSurveyKind()) {
				case TeamMember:
					bo.setSurveyKind(SurveyKindBo.TeamMember);
					break;
				case TeamManager:
					bo.setSurveyKind(SurveyKindBo.TeamManager);
					break;
				case Consensus:
					bo.setSurveyKind(SurveyKindBo.Consensus);
					break;
			}
			bo.setSurveySections(surveySectionConverter.convertToBos(entity.getSurveySections()));
		} 
		return bo;
	}

}
