package colruyt.pcrsejb.util.validators.surveyDefinition.survey;

import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.InvalidSurveySectionStrategyException;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.InvalidSurveySectionTitleException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;
import colruyt.pcrsejb.util.validators.GenericValidator;

public class SurveySectionDefinitionValidator implements GenericValidator<SurveySectionDefinition> {

	@Override
	public void validate(SurveySectionDefinition toValidate) throws ValidationException {
		this.validateSurveySectionTitle(toValidate.getSurveySectionTitle());
		this.validateSurveySectionStrategy(toValidate.getSurveySectionStrategy());
	}

	private void validateSurveySectionTitle(SurveySectionTitle surveySectionTitle) throws InvalidSurveySectionTitleException {
		if (surveySectionTitle == null) {
			throw new InvalidSurveySectionTitleException();
		}
	}
	
	private void validateSurveySectionStrategy(SurveySectionStrategy surveySectionStrategy) throws InvalidSurveySectionStrategyException {
		if (surveySectionStrategy == null) {
			throw new InvalidSurveySectionStrategyException();
		}
	}
	
}
