package colruyt.pcrsejb.util.exceptions;

import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

public class SurveyDoesNotExistException extends ValidationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SurveyDoesNotExistException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SurveyDoesNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SurveyDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SurveyDoesNotExistException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SurveyDoesNotExistException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	
}
