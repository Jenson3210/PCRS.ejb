package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;
import colruyt.pcrsejb.facade.surveyDefinition.strategy.ISurveySectionStrategyFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Named
@ViewScoped
public class SurveySectionStrategyView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private ISurveySectionStrategyFacade surveySectionStrategyFacade; 
	private SurveySectionStrategyBo surveySectionStrategyBo;
	
	private List<SurveySectionStrategyBo> strategies;
	
	@PostConstruct 
	private void fillStrategies() {
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
 
	public void addSurveySectionStrategy() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			strategies.add(surveySectionStrategyFacade.save(surveySectionStrategyBo));
		} catch (ValidationException e) {
			System.out.println(e.getMessage() + " 1****" + e.getClass() + " 2****" + e.toString() + " 3****" + e.getLocalizedMessage() + " 4****" +
					e.toString() + " 5****" + e.fillInStackTrace() + " 6****" + e.getCause() + " 7****" + e.getStackTrace());
			System.out.println("komthijhier??????????????");
			context.addMessage(null, new FacesMessage(e.getMessage()));
		}	
	}
	
	public void newSurveySectionStrategy() {
        surveySectionStrategyBo = new SurveySectionStrategyBo();
    }
	
	public void editSurveySectionStrategy() {
		FacesContext context = FacesContext.getCurrentInstance();
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
		try {
			surveySectionStrategyFacade.save(s);
		} catch (ValidationException e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
		}
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
