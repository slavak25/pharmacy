package by.koshman.pharmacy.logic.impl;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import by.koshman.pharmacy.controller.RequestParameterName;
import by.koshman.pharmacy.controller.JspPageName;
import by.koshman.pharmacy.dao.DaoFactory;
import by.koshman.pharmacy.dao.DaoException;
import by.koshman.pharmacy.dao.DaoFactory.DaoType;
import by.koshman.pharmacy.dao.impl.DaoMySQL;
import by.koshman.pharmacy.logic.ICommand;
import by.koshman.pharmacy.logic.CommandException;
import by.koshman.pharmacy.entity.Customer;
public class AddCustomerCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws CommandException{
		String page = null;
		DaoMySQL dao = null;
		String firstName = request.getParameter(RequestParameterName.FIRST_NAME);
		String lastName = request.getParameter(RequestParameterName.LAST_NAME);		
		Date dateOfBirth = Date.valueOf(request.getParameter(RequestParameterName.DATE_OF_BIRTH));		
		String address = request.getParameter(RequestParameterName.ADDRESS);
		String phone = request.getParameter(RequestParameterName.PHONE);
		String email = request.getParameter(RequestParameterName.EMAIL);
		byte leftEye = Byte.valueOf(request.getParameter(RequestParameterName.LEFT_EYE));
		byte rightEye = Byte.valueOf(request.getParameter(RequestParameterName.RIGHT_EYE));
		
		try{			
			dao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.MYSQL);
			dao.addCustomer(firstName, lastName, dateOfBirth, address, phone, email, leftEye, rightEye);
			
			page = JspPageName.RESPONSE_PAGE;
			
		} catch(DaoException exception){
			throw new CommandException("Cann't get DAO", exception);
		}		
		return page;
	}
}
