package colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class InvalidSurveySectionTitleException extends ValidationException {

	private static final long serialVersionUID = 1L;

	public InvalidSurveySectionTitleException() {
		super("Survey section title cannot be empty.");
	}

}
