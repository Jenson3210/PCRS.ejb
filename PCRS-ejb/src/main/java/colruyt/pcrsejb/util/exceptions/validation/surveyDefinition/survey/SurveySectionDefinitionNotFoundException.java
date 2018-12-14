package colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class SurveySectionDefinitionNotFoundException extends ValidationException {

	private static final long serialVersionUID = 1L;
	
	public SurveySectionDefinitionNotFoundException() {
		super("Survey section strategy cannot be found.");
	}

}
