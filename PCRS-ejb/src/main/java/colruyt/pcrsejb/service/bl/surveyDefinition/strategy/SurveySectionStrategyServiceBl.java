package colruyt.pcrsejb.service.bl.surveyDefinition.strategy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityNotFoundException;

import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.service.bl.surveyDefinition.survey.ISurveySectionDefinitionServiceBl;
import colruyt.pcrsejb.service.bl.surveyDefinition.survey.SurveySectionDefinitionServiceBl;
import colruyt.pcrsejb.service.dl.surveyDefinition.strategy.ISurveySectionStrategyServiceDL;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.strategy.SurveySectionStrategyCantBeDeletedException;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.strategy.SurveySectionStrategyNotFoundException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;
import colruyt.pcrsejb.util.validators.surveyDefinition.strategy.StrategyValidator;

@Stateless
public class SurveySectionStrategyServiceBl implements Serializable, ISurveySectionStrategyServiceBl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ISurveySectionStrategyServiceDL surveySectionStrategyServiceDL;
	
	@EJB
	private ISurveySectionDefinitionServiceBl surveySectionDefinitionServiceBl;

	
	private StrategyValidator strategyValidator = new StrategyValidator();

	@Override
	public SurveySectionStrategy save(SurveySectionStrategy element) throws ValidationException {
		strategyValidator.validate(element);
		return surveySectionStrategyServiceDL.save(element);
	}

	@Override
	public SurveySectionStrategy get(SurveySectionStrategy element) throws ValidationException {
		try {
		return surveySectionStrategyServiceDL.get(element);
		}
		catch(EntityNotFoundException e)
		{
			throw new SurveySectionStrategyNotFoundException();
		}
	}

	@Override
	public List<SurveySectionStrategy> getAll() {
		return surveySectionStrategyServiceDL.getAll();
	}

	@Override
	public void delete(SurveySectionStrategy element) throws ValidationException {
		List<SurveySectionDefinition> ssDefList = new ArrayList<>();
		ssDefList = surveySectionDefinitionServiceBl.getAll();
		for (SurveySectionDefinition ssd: ssDefList) {
			if (ssd.getSurveySectionStrategy().getId() == element.getId()) {
				throw new SurveySectionStrategyCantBeDeletedException();
			}
			
		}
		surveySectionStrategyServiceDL.delete(element);
	}
	
	public Boolean isSurveySectionStrategyUsed(SurveySectionStrategy surveySectionStrategy) {
		Boolean strategyUsed = false;
		List<SurveySectionDefinition> ssDefList = new ArrayList<>();
		ssDefList = surveySectionDefinitionServiceBl.getAll();
		for(SurveySectionDefinition ssd: ssDefList) {
			if(ssd.getSurveySectionStrategy().getId() == surveySectionStrategy.getId()) {
				strategyUsed = true;
			}	
		}
		return strategyUsed;

	}
}
