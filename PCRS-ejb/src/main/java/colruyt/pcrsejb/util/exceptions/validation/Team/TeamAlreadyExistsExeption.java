package colruyt.pcrsejb.util.exceptions.validation.Team;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class TeamAlreadyExistsExeption extends ValidationException {
    public TeamAlreadyExistsExeption(String message) {
        super(message);
    }
}
