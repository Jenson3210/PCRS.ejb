package colruyt.pcrsejb.util.exceptions.validation.Team;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class TeamDoesNotExistExeption extends ValidationException {
    public TeamDoesNotExistExeption(String message) {
        super(message);
    }
}
