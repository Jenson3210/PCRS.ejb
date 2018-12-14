package colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class SurveySectionDefinitionCantBeDeletedException extends ValidationException {
	
	private static final long serialVersionUID = 1L;
	
	public SurveySectionDefinitionCantBeDeletedException() {
		super("Survey section strategy cannot be deleted.");
	}

}
