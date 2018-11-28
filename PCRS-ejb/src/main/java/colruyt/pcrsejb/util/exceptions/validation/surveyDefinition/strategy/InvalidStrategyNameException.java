package colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.strategy;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class InvalidStrategyNameException extends ValidationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidStrategyNameException() {
		super("Invalid strategy name was entered.");
		
	}

}
