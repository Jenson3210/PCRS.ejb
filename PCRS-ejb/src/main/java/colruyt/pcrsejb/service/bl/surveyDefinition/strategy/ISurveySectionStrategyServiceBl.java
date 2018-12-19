package colruyt.pcrsejb.service.bl.surveyDefinition.strategy;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.service.bl.IServiceBl;

@Local
public interface ISurveySectionStrategyServiceBl extends IServiceBl<SurveySectionStrategy> {
	public Boolean isSurveySectionStrategyUsed(SurveySectionStrategy surveySectionStrategy);
}
