package colruyt.pcrsejb.service.bl.surveyDefinition.strategy;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.service.dl.surveyDefinition.strategy.ISurveySectionStrategyServiceDL;

@Stateless
public class SurveySectionStrategyServiceBl implements Serializable, ISurveySectionStrategyServiceBl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ISurveySectionStrategyServiceDL surveySectionStrategyServiceDL;

	@Override
	public SurveySectionStrategy save(SurveySectionStrategy element) {
		return surveySectionStrategyServiceDL.save(element);
	}

	@Override
	public SurveySectionStrategy get(SurveySectionStrategy element) {
		return surveySectionStrategyServiceDL.get(element);
	}

	@Override
	public List<SurveySectionStrategy> getAll() {
		return surveySectionStrategyServiceDL.getAll();
	}

	@Override
	public void delete(SurveySectionStrategy element) {
		surveySectionStrategyServiceDL.delete(element);	
	}
}
