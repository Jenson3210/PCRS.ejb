package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

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
		PrimeFaces pf = PrimeFaces.current();
		try {
			strategies.add(surveySectionStrategyFacade.save(surveySectionStrategyBo));
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}	
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
		try {
			surveySectionStrategyFacade.delete(s);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
 			e.printStackTrace();
		}
	}
}
