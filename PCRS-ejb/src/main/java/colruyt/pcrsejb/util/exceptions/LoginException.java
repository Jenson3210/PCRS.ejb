package colruyt.pcrsejb.util.exceptions;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class LoginException extends ValidationException{

	public LoginException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public LoginException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LoginException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LoginException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
