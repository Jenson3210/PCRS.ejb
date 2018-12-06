package colruyt.pcrsejb.util.validators.surveyDefinition.strategy;

import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.strategy.InvalidAmountOfLevelsException;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.strategy.InvalidStrategyNameException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;
import colruyt.pcrsejb.util.validators.GenericValidator;

public class StrategyValidator implements GenericValidator<SurveySectionStrategy> {

    @Override
    public void validate(SurveySectionStrategy toValidate) throws ValidationException {
    	this.validateName(toValidate.getName());
    	this.validateAmountOfLevels(toValidate.getAmountOfLevels());
    }

    private void validateName(String name) throws InvalidStrategyNameException {
        if(name == null || name.isEmpty()){
            throw new InvalidStrategyNameException();
        }
    }

    private void validateAmountOfLevels(Integer amount) throws InvalidAmountOfLevelsException {
        if(amount == null || amount < 2 || amount > 9){
            throw new InvalidAmountOfLevelsException();
        }
    }
   
}
