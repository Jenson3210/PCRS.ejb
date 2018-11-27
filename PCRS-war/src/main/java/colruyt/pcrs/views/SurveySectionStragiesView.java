package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;

@Named
@ViewScoped
public class SurveySectionStragiesView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ISurveySectionStrategyFacade surveySectionStrategyFacade; 
	private SurveySectionStrategyBo surveySectionStrategyBo;
	
	private List<SurveySectionStrategyBo> strategies;
	
	@PostConstruct 
	private void fillstrategies() {
		strategies = surveySectionStrategyFacade.getAll();
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

	public void addSurveySectionStrategy()
	{
		strategies.add(surveySectionStrategyFacade.save(surveySectionStrategyBo));
	}
	
	public void newSurveySectionStrategy() {
        surveySectionStrategyBo = new SurveySectionStrategyBo();
    }
	
	public void editSurveySectionStrategy() {
		SurveySectionStrategyBo s = null;
		for (SurveySectionStrategyBo strategy : strategies) {
			if (strategy.getId() == surveySectionStrategyBo.getId()) {
				strategy.setAmountOfLevels(surveySectionStrategyBo.getAmountOfLevels());
				strategy.setDescriptionRequired(surveySectionStrategyBo.getDescriptionRequired());
				strategy.setEnergyRated(surveySectionStrategyBo.getEnergyRated());
				strategy.setFlexibleDescription(surveySectionStrategyBo.getFlexibleDescription());
				strategy.setInterestRated(surveySectionStrategyBo.getInterestRated());
				strategy.setName(surveySectionStrategyBo.getName());
				strategy.setHasMinimumLevel(surveySectionStrategyBo.getHasMinimumLevel());
				s = strategy;
			}
		}
		surveySectionStrategyFacade.save(s); 
	}
	
	public void deleteSurveySectionStrategy()
	{
		SurveySectionStrategyBo s = null;
		for (SurveySectionStrategyBo strategy : strategies) {
			if (strategy.getId() == surveySectionStrategyBo.getId()) {
				s = strategy;
			}
		}
		strategies.remove(s);
		surveySectionStrategyFacade.delete(s);
	}
}
