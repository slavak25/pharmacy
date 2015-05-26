package by.koshman.pharmacy.dao.impl;
import java.util.ArrayList;
import java.util.List;

import by.koshman.pharmacy.entity.Customer;
import by.koshman.pharmacy.entity.Visit;
import by.koshman.pharmacy.dao.Dao;
import by.koshman.pharmacy.dao.DaoException;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

public final class DaoMySQL implements Dao{
	private static final String SQL_GET_CUSTOMER = "SELECT * FROM customers WHERE first_name = ? AND last_name = ?";
	private static final String SQL_GET_VISIT_LIST = "SELECT * FROM visits WHERE customer = ?";
	private static final String SQL_ADD_CUSTOMER = "INSERT INTO customers (first_name, last_name, date_of_birth, address, phone, email, left_eye, right_eye) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_ADD_VISIT = "INSERT INTO visits (date, amount, status, customer) VALUES (?, ?, ?, ?)";
	private static final String SQL_UPDATE_VISIT = "UPDATE visits SET date = ?, amount = ?, status = ? WHERE id = ?";
	private static final String SQL_DELETE_VISIT = "DELETE FROM visits WHERE id=?";
	private Connection connection;	
	
	private DaoMySQL(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");			
		} catch (ClassNotFoundException exception){
			exception.printStackTrace();
		}
		
		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacy", "root", "admin");
		} catch (SQLException exception){
			exception.printStackTrace();
		}
	}
	
	private static DaoMySQL instance;
	
	public static DaoMySQL getInstance(){
		
		if(instance ==null){
			instance = new DaoMySQL();
		}	
		return instance;
	}
	
	@Override
	public Customer getCustomer(String  firstName, String lastName) throws DaoException{
		Customer customer = null;		
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try{			
			preparedStatement = connection.prepareStatement(SQL_GET_CUSTOMER);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next()){
				customer = new Customer();				
				customer.setId(resultSet.getInt("id"));
				customer.setFirstName(resultSet.getString("first_name"));
				customer.setLastName(resultSet.getString("last_name"));
				customer.setDateOfBirth(resultSet.getDate("date_of_birth"));
				customer.setAddress(resultSet.getString("address"));
				customer.setPhone(resultSet.getString("phone"));
				customer.setEmail(resultSet.getString("email"));
				customer.setLeftEye(resultSet.getByte("left_eye"));
				customer.setRightEye(resultSet.getByte("right_eye"));				
			}							
		} catch (SQLException exception){
				exception.printStackTrace();		
		}
		
		return customer;		
	}
	
	@Override
	public List<Visit> getVisitList(int id){
		Visit visit = null;
		List <Visit> list = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try{
			preparedStatement = connection.prepareStatement(SQL_GET_VISIT_LIST);			
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			list = new ArrayList<Visit>();
			while(resultSet.next()){
				visit = new Visit();				
				visit.setId(resultSet.getInt("id"));
				visit.setVisitDate(resultSet.getDate("date"));
				visit.setAmount(resultSet.getFloat("amount"));
				visit.setStatus(resultSet.getString("status"));
				visit.setCustomerId(resultSet.getInt("customer"));
				list.add(visit);				
			}	
		} catch (SQLException exception){
			exception.printStackTrace();
		}		
		return list;
	}		
		
	@Override
	public void addCustomer(String firstName, String lastName, Date dateOfBirth, String address, String phone, String email, byte leftEye, byte rightEye){
		PreparedStatement preparedStatement = null;
		boolean resultSet;
		
		try{
			preparedStatement = connection.prepareStatement(SQL_ADD_CUSTOMER);
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			preparedStatement.setDate(3, dateOfBirth);
			preparedStatement.setString(4, address);
			preparedStatement.setString(5, phone);
			preparedStatement.setString(6, email);
			preparedStatement.setByte(7, leftEye);
			preparedStatement.setByte(8, rightEye);
			resultSet = preparedStatement.execute();
		} catch (SQLException exception){
			exception.printStackTrace();		
		}
	}
	
	@Override
	public void addVisit(Date visitDate, float amount, String status, int customerId){
		PreparedStatement preparedStatement = null;
		boolean resultSet;
		
		try{
			preparedStatement = connection.prepareStatement(SQL_ADD_VISIT);
			preparedStatement.setDate(1, visitDate);
			preparedStatement.setFloat(2, amount);
			preparedStatement.setString(3, status);
			preparedStatement.setInt(4, customerId);
			resultSet = preparedStatement.execute();
		} catch (SQLException exception){
			exception.printStackTrace();		
		}
	}
	public void updateVisit(Date visitDate, float amount, String status, int id){
		PreparedStatement preparedStatement = null;
		int resultSet;
		
		try{
			preparedStatement = connection.prepareStatement(SQL_UPDATE_VISIT);
			preparedStatement.setDate(1, visitDate);
			preparedStatement.setFloat(2, amount);
			preparedStatement.setString(3, status);
			preparedStatement.setInt(4, id);
			resultSet = preparedStatement.executeUpdate();
		} catch (SQLException exception){
			exception.printStackTrace();		
		}
	}
	public void deleteVisit(int id){
		PreparedStatement preparedStatement = null;
		boolean resultSet;
		
		try{
			preparedStatement = connection.prepareStatement(SQL_DELETE_VISIT);			
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.execute();
		} catch (SQLException exception){
			exception.printStackTrace();		
		}
	}
}
	

