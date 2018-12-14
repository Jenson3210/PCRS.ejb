package colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class SurveySectionTitleCantBeDeletedException extends ValidationException {

	private static final long serialVersionUID = 1L;
	
	public SurveySectionTitleCantBeDeletedException() {
		super("Section title can't be deleted.");
	}
}
