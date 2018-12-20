package colruyt.pcrsejb.util.exceptions;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class TeamHasNoManagerException extends ValidationException {

	public TeamHasNoManagerException() {
		super("Team has no manager.");
	}
	
	

}
