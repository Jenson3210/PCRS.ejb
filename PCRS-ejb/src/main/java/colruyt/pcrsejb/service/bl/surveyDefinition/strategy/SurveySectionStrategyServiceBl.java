package colruyt.pcrsejb.service.bl.surveyDefinition.strategy;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.service.dl.surveyDefinition.strategy.ISurveySectionStrategyServiceDL;
import colruyt.pcrsejb.service.dl.surveyDefinition.survey.DbSurveySectionDefinitionServiceDl;
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
	
	private StrategyValidator strategyValidator = new StrategyValidator();

	@Override
	public SurveySectionStrategy save(SurveySectionStrategy element) throws ValidationException {
		strategyValidator.validate(element);
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
	public void delete(SurveySectionStrategy element) throws ValidationException {
		DbSurveySectionDefinitionServiceDl dbsdsdl = new DbSurveySectionDefinitionServiceDl();
		List<SurveySectionDefinition> sdsList = dbsdsdl.getSurveySectionDefinitionsForStrategy(element);
		if ( sdsList == null) {
			surveySectionStrategyServiceDL.delete(element);
			System.out.println("+++++++ na delete +++++++++");
		}
		else {
			System.out.println("++++++++++ komt in exception +++++++++");
			throw new ValidationException("Can't remove survey strategy, still in use");
		}
	}
}
