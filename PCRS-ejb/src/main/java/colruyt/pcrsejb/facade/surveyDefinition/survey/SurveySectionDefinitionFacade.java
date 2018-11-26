package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionDefinitionConverter;
import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionRequirementLevel;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.service.bl.surveyDefinition.survey.ISurveySectionDefinitionServiceBl;

@Stateless
public class SurveySectionDefinitionFacade implements Serializable, ISurveySectionDefinitionFacade {
	private static final long serialVersionUID = 1L;

	@EJB
	private ISurveySectionDefinitionServiceBl surveySectionDefinitionServiceBl;
	private SurveySectionDefinitionConverter surveySectionDefinitionConverter = new SurveySectionDefinitionConverter();

	@Override
	public SurveySectionDefinitionBo save(SurveySectionDefinitionBo surveySectionDefinition) {
		return surveySectionDefinitionConverter.convertToBo(surveySectionDefinitionServiceBl
				.save(surveySectionDefinitionConverter.convertToEntity(surveySectionDefinition)));
	}

	@Override
	public SurveySectionDefinitionBo get(SurveySectionDefinitionBo surveySectionDefinition) {
		return surveySectionDefinitionConverter.convertToBo(surveySectionDefinitionServiceBl
				.get(surveySectionDefinitionConverter.convertToEntity(surveySectionDefinition)));
	}

	@Override
	public List<SurveySectionDefinitionBo> getAll() {
		return surveySectionDefinitionConverter.convertToBos(surveySectionDefinitionServiceBl.getAll());
	}

	@Override
	public void delete(SurveySectionDefinitionBo surveySectionDefinition) {
		surveySectionDefinitionServiceBl
				.delete(surveySectionDefinitionConverter.convertToEntity(surveySectionDefinition));
	}

	@Override
	public SurveySectionDefinitionBo getSurveySectionTitle(SurveySectionTitle surveySectionTitle) {
		return surveySectionDefinitionConverter
				.convertToBo(surveySectionDefinitionServiceBl.getSurveySectionTitle(surveySectionTitle));
	}

	@Override
	public SurveySectionDefinitionBo getSurveySectionStrategy(SurveySectionStrategy surveySectionStrategy) {
		return surveySectionDefinitionConverter
				.convertToBo(surveySectionDefinitionServiceBl.getSurveySectionStrategy(surveySectionStrategy));
	}

	@Override
	public SurveySectionDefinitionBo getSurveySectionRequirementLevel(
			SurveySectionRequirementLevel surveySectionRequirementLevel) {
		return surveySectionDefinitionConverter.convertToBo(
				surveySectionDefinitionServiceBl.getSurveySectionRequirementLevel(surveySectionRequirementLevel));
	}

	@Override
	public List<SurveySectionDefinitionBo> getSurveySectionCompetences() {
		return surveySectionDefinitionConverter.convertToBos(surveySectionDefinitionServiceBl.getAll());
	}

}
