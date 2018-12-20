package colruyt.pcrsejb.util.exceptions;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class MemberAlreadyHasATeamException extends ValidationException {

	private static final long serialVersionUID = 1L;

	public MemberAlreadyHasATeamException() {
		super("Member already has an active team.");
	}
	
	

}
