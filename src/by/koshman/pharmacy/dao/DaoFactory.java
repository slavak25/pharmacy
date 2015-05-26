package by.koshman.pharmacy.dao;
import by.koshman.pharmacy.dao.impl.DaoMySQL;

public class DaoFactory {
	private final static DaoFactory instance = new DaoFactory();
	
	public enum DaoType{
		MYSQL;
	}
	
	public static DaoFactory getInstance(){
		return instance;
	}
	
	public DaoMySQL getDao(DaoType type) throws DaoException{
				
		switch (type){
		case MYSQL:
			return DaoMySQL.getInstance();
		default:
			throw new DaoException("No such DAO");
		}		
	}
}
