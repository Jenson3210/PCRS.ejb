package colruyt.pcrsejb.util.exceptions.validation.Team;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class TeamhasAManagerException extends ValidationException {

    public TeamhasAManagerException() {
        super("Team already has a manager.");
    }
}
