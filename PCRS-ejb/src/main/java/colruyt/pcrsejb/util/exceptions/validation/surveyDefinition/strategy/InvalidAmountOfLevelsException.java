package colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.strategy;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class InvalidAmountOfLevelsException extends ValidationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAmountOfLevelsException() {
		super("Invalid strategy amount of levels was entered.");
		
	}

}