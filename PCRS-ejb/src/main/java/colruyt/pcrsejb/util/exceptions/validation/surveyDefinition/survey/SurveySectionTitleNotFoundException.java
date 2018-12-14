package colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class SurveySectionTitleNotFoundException extends ValidationException{

	private static final long serialVersionUID = 1L;
	
	public SurveySectionTitleNotFoundException() {
		super("Section title could not be found.");
	}
}
