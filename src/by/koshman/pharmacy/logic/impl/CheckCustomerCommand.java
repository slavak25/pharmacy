package by.koshman.pharmacy.logic.impl;
import by.koshman.pharmacy.controller.RequestParameterName;
import by.koshman.pharmacy.controller.JspPageName;
import by.koshman.pharmacy.dao.DaoFactory;
import by.koshman.pharmacy.dao.DaoException;
import by.koshman.pharmacy.dao.DaoFactory.DaoType;
import by.koshman.pharmacy.dao.impl.DaoMySQL;
import by.koshman.pharmacy.logic.ICommand;

import javax.servlet.http.HttpServletRequest;

import by.koshman.pharmacy.logic.CommandException;
import by.koshman.pharmacy.entity.Customer;

public class CheckCustomerCommand implements ICommand {
	
	@Override
	public String execute(HttpServletRequest request) throws CommandException{
		String page = null;
		DaoMySQL dao = null;
		String firstName = request.getParameter(RequestParameterName.FIRST_NAME);
		String lastName = request.getParameter(RequestParameterName.LAST_NAME);
		
		try{
			
			dao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.MYSQL);
			Customer customer = dao.showCustomerWithVisitList(firstName, lastName);
			
			request.getSession().setAttribute("cust", customer);
			page = JspPageName.USER_PAGE;
			
		} catch(DaoException exception){
			throw new CommandException("Cann't get DAO", exception);
		}
		
		return page;
	}
}
