package colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.strategy;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class SurveySectionStrategyNotFoundException extends ValidationException{

	private static final long serialVersionUID = 1L;
	
	public SurveySectionStrategyNotFoundException() {
		super("Section strategy could not be found.");
	}
}
