package colruyt.pcrsejb.util.exceptions;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class UserEmailAddressAlreadyExistsException extends ValidationException {

	
	private static final long serialVersionUID = 1L;

	public UserEmailAddressAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserEmailAddressAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserEmailAddressAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserEmailAddressAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserEmailAddressAlreadyExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	
}
