package by.koshman.pharmacy.logic;
import by.koshman.pharmacy.exception.ProjectException; 

public class CommandException extends ProjectException{
	private static final long serialVersionUID = 1L;
	
	public CommandException() {}
	
	public CommandException(String message, Exception exception) {
		super(message, exception);
	}
	
	public CommandException(String message) {
		super(message);
	}
	
	public CommandException(Exception exception) {
		super(exception);
	}
}
