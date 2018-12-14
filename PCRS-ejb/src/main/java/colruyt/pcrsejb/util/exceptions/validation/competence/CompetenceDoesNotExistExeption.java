package colruyt.pcrsejb.util.exceptions.validation.competence;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class CompetenceDoesNotExistExeption extends ValidationException {
    public CompetenceDoesNotExistExeption(String s) {
        super(s);
    }
}
