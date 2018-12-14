package colruyt.pcrsejb.util.exceptions.validation.surveySet;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class SurveySetDoesNotExistException extends ValidationException {

	private static final long serialVersionUID = 1L;

	public SurveySetDoesNotExistException() {
		super("There is no surveyset with this id.");
		
	}

}
