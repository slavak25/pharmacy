package by.koshman.pharmacy.dao;
import java.util.List;
import java.sql.Date;
import by.koshman.pharmacy.entity.Customer;
import by.koshman.pharmacy.entity.Visit;

public interface Dao {	
	Customer getCustomer(String firstName, String lastName) throws DaoException;
	List<Visit> getVisitList(int customerId) throws DaoException;
	void addCustomer(String firstName, String lastName, Date dateOfBirth, String address, String phone, String email, byte leftEye, byte rightEye) throws DaoException;
	void addVisit(Date visitDate, float amount, String status, int customerId) throws DaoException;
	void updateVisit(Date visitDate, float amount, String status, int customerId) throws DaoException;
	void deleteVisit(int id) throws DaoException;
}
