package colruyt.pcrsejb.converter.surveys.survey;

import colruyt.pcrsejb.bo.surveys.survey.SurveyKindBo;
import colruyt.pcrsejb.entity.surveys.survey.SurveyKind;

public class SurveyKindTranslator {

	public SurveyKind convertToEntity(SurveyKindBo bo) {
		SurveyKind entity = null;
		if (bo != null) {
			switch (bo) {
			case TeamMember:
				entity = SurveyKind.TeamMember;
				break;
			case TeamManager:
				entity = SurveyKind.TeamManager;
				break;
			case Consensus:
				entity = SurveyKind.Consensus;
				break;
			}
		}
		return entity;
	}

	public SurveyKindBo convertToBo(SurveyKind entity) {
		SurveyKindBo bo = null;
		if (entity != null) {
			switch (entity) {
			case TeamMember:
				bo = SurveyKindBo.TeamMember;
				break;
			case TeamManager:
				bo = SurveyKindBo.TeamManager;
				break;
			case Consensus:
				bo = SurveyKindBo.Consensus;
				break;
			}
		}
		return bo;
	}

}
