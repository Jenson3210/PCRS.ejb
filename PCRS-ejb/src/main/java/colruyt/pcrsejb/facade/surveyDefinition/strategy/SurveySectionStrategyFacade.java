package colruyt.pcrsejb.facade.surveyDefinition.strategy;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.converter.surveyDefinition.strategy.SurveySectionStrategyConverter;
import colruyt.pcrsejb.service.bl.surveyDefinition.strategy.ISurveySectionStrategyServiceBl;

@Stateless
public class SurveySectionStrategyFacade implements Serializable, ISurveySectionStrategyFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ISurveySectionStrategyServiceBl surveySectionStrategyServiceBl;
	private SurveySectionStrategyConverter surveySectionStrategyConverter = new SurveySectionStrategyConverter();


	@Override
	public SurveySectionStrategyBo save(SurveySectionStrategyBo entityBo) {
		return surveySectionStrategyConverter.convertToBo(surveySectionStrategyServiceBl.save(surveySectionStrategyConverter.convertToEntity(entityBo)));
	}

	@Override
	public SurveySectionStrategyBo get(SurveySectionStrategyBo entityBo) {
		return surveySectionStrategyConverter.convertToBo(surveySectionStrategyServiceBl.get(surveySectionStrategyConverter.convertToEntity(entityBo)));
	}

	@Override
	public List<SurveySectionStrategyBo> getAll() {
		return surveySectionStrategyConverter.convertToBos(surveySectionStrategyServiceBl.getAll());
	}

	@Override
	public void delete(SurveySectionStrategyBo entityBo) {
		surveySectionStrategyServiceBl.delete(surveySectionStrategyConverter.convertToEntity(entityBo));
	}
}
