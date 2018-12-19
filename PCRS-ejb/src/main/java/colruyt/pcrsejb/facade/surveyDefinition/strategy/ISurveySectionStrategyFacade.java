package colruyt.pcrsejb.facade.surveyDefinition.strategy;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.facade.IFacade;

@Local
public interface ISurveySectionStrategyFacade extends IFacade<SurveySectionStrategyBo> {
	public Boolean isSurveySectionStrategyUsed(SurveySectionStrategyBo surveySectionStrategyBo);
}
