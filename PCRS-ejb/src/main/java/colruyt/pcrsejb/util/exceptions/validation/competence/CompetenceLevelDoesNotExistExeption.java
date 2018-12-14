package colruyt.pcrsejb.util.exceptions.validation.competence;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class CompetenceLevelDoesNotExistExeption extends ValidationException {
    public CompetenceLevelDoesNotExistExeption(String s) {
        super(s);
    }
}
