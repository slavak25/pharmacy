package by.koshman.pharmacy.exception;

public class ProjectException extends Exception{

	private static final long serialVersionUID = 1L;
	private Exception hiddenException;
	
	public ProjectException() {}
	
	public ProjectException(String message, Exception exception) {
		super(message, exception);
		hiddenException = exception;
	}
	
	public ProjectException(String message) {
		super(message);
	}
	
	public ProjectException(Exception exception) {
		super(exception);
		hiddenException = exception;
	}
	
	public Exception getHiddenException(){
		return hiddenException;
	}
}
