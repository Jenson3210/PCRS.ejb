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

/**
 * Survey section strategy view
 * @author jda1mbw
 */
@Named
@ViewScoped
public class SurveySectionStrategyView implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	private ISurveySectionStrategyFacade surveySectionStrategyFacade; 
	private SurveySectionStrategyBo surveySectionStrategyBo;
	private List<SurveySectionStrategyBo> strategies;
	
	/**
	 * Method to fill the List strategies
	 */
	@PostConstruct
	private void fillStrategies() {
		strategies = surveySectionStrategyFacade.getAll();
	} 
 
	/**
	 * Method to get a SurveySectionStrategyBo
	 * @return surveySectionStrategyBo
	 */
	public SurveySectionStrategyBo getSurveySectionStrategyBo() {
		return surveySectionStrategyBo; 
	}
	
	/**
	 * Method to set SurveySectionStrategyBo
	 * @param surveySectionStrategyBo
	 */
	public void setSurveySectionStrategyBo(SurveySectionStrategyBo surveySectionStrategyBo) {
		this.surveySectionStrategyBo = surveySectionStrategyBo;
	}
	
	/**
	 * Method to get a list of Strategies
	 * @return strategies
	 */
	public List<SurveySectionStrategyBo> getStrategies() {
		return strategies;
	}
	
	/**
	 * Method to set a list of strategies
	 * @param strategies
	 */
	public void setStrategies(List<SurveySectionStrategyBo> strategies) {
		this.strategies = strategies;
	}
 
	/**
	 * Method to add a SurveySectionStrategy
	 */
	public void addSurveySectionStrategy() {
		PrimeFaces pf = PrimeFaces.current();
		try {
			strategies.add(surveySectionStrategyFacade.save(surveySectionStrategyBo));
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("addForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}	
	}
	
	/**
	 * Method to create a new SurveySectionStrategy
	 */
	public void newSurveySectionStrategy() {
        surveySectionStrategyBo = new SurveySectionStrategyBo();
    }
	
	/**
	 * Method to edit a SurveySectionStrategy
	 */
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
		PrimeFaces pf = PrimeFaces.current();
		try {
			surveySectionStrategyFacade.save(s);
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) { 
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("editForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));	
		}
	}
	
	/**
	 * Method to delete a SurveySectionStrategy
	 */
	public void deleteSurveySectionStrategy()
	{
		SurveySectionStrategyBo s = null;
		for (SurveySectionStrategyBo strategy : strategies) {
			if (strategy.getId() == surveySectionStrategyBo.getId()) {
				s = strategy;
			}
		}
//		strategies.remove(s);
		try {
			surveySectionStrategyFacade.delete(s);
			strategies.remove(s);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "succesfully deleted", null));
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
//		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "succesfully deleted", null));
	}
}
