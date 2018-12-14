package colruyt.pcrsejb.util.exceptions;

public class NoSurveySetException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoSurveySetException() {
		super();
	}

	public NoSurveySetException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public NoSurveySetException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NoSurveySetException(String arg0) {
		super(arg0);
	}

	public NoSurveySetException(Throwable arg0) {
		super(arg0);
	}
}
