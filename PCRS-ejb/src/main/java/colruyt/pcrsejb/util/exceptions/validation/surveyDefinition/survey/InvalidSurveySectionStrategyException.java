package colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class InvalidSurveySectionStrategyException extends ValidationException {
	
	private static final long serialVersionUID = 1L;
	
	public InvalidSurveySectionStrategyException() {
		super("Survey section strategy cannot be empty.");
	}

}
