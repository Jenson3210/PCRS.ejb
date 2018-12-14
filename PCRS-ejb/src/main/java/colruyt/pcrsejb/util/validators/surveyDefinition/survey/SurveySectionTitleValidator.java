package colruyt.pcrsejb.util.validators.surveyDefinition.survey;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.InvalidSurveySectionTitleException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;
import colruyt.pcrsejb.util.validators.GenericValidator;

public class SurveySectionTitleValidator implements GenericValidator<SurveySectionTitle> {

	@Override
	public void validate(SurveySectionTitle toValidate) throws ValidationException {
		this.validateTitle(toValidate.getTitle());
	}
	
	private void validateTitle(String title) throws InvalidSurveySectionTitleException{
		if(title == null || title.isEmpty()) {
			throw new InvalidSurveySectionTitleException();
		}
	}
	
}
