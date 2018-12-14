package colruyt.pcrsejb.util.exceptions.validation.competence;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class CompetenceAlreadyExistExeption extends ValidationException {
    public CompetenceAlreadyExistExeption(String s) {
        super(s);
    }
}
