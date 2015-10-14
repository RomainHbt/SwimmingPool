package exceptions;

public class ActionFinishedException extends Exception{

	private static final long serialVersionUID = 1L;

	public ActionFinishedException() {
		super("This action is already terminated.");
	}
	
}
