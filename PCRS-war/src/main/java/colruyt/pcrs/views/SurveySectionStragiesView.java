package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;

@Named
@ViewScoped
public class SurveySectionStragiesView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ISurveySectionStrategyFacade surveySectionStrategyFacade; 
	private SurveySectionStrategyBo surveySectionStrategyBo;
	private List<SurveySectionStrategyBo> strategies;
	
	
	public ISurveySectionStrategyFacade getSurveySectionStrategyFacade() {
		return surveySectionStrategyFacade;
	}
	public void setSurveySectionStrategyFacade(ISurveySectionStrategyFacade surveySectionStrategyFacade) {
		this.surveySectionStrategyFacade = surveySectionStrategyFacade;
	}
	public SurveySectionStrategyBo getSurveySectionStrategyBo() {
		return surveySectionStrategyBo;
	}
	public void setSurveySectionStrategyBo(SurveySectionStrategyBo surveySectionStrategyBo) {
		this.surveySectionStrategyBo = surveySectionStrategyBo;
	}
	public List<SurveySectionStrategyBo> getStrategies() {
		return strategies;
	}
	public void setStrategies(List<SurveySectionStrategyBo> strategies) {
		this.strategies = strategies;
	}

}
