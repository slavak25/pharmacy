package by.koshman.pharmacy.dao;
import by.koshman.pharmacy.exception.ProjectException;

public class DaoException extends ProjectException {
	
	private static final long serialVersionUID = 1L;
			
	public DaoException() {}
	
	public DaoException(String message, Exception exception) {
		super(message, exception);
	}
	
	public DaoException(String message) {
		super(message);
	}
	
	public DaoException(Exception exception) {
		super(exception);
	}
}
