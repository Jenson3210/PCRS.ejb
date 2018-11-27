package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionDefinitionConverter;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionTitleConverter;
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
	public SurveySectionDefinitionBo save(SurveySectionDefinitionBo entityBo) {
		return surveySectionDefinitionConverter.convertToBo(
				surveySectionDefinitionServiceBl.save(surveySectionDefinitionConverter.convertToEntity(entityBo)));
	}

	@Override
	public SurveySectionDefinitionBo get(SurveySectionDefinitionBo entityBo) {
		return surveySectionDefinitionConverter.convertToBo(
				surveySectionDefinitionServiceBl.get(surveySectionDefinitionConverter.convertToEntity(entityBo)));
	}

	@Override
	public List<SurveySectionDefinitionBo> getAll() {
		return surveySectionDefinitionConverter.convertToBos(surveySectionDefinitionServiceBl.getAll());
	}

	@Override
	public void delete(SurveySectionDefinitionBo entityBo) {
		surveySectionDefinitionServiceBl.delete(surveySectionDefinitionConverter.convertToEntity(entityBo));	
	}
	
}
