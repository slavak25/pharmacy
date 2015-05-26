package by.koshman.pharmacy.logic.impl;
import by.koshman.pharmacy.controller.RequestParameterName;
import by.koshman.pharmacy.controller.JspPageName;
import by.koshman.pharmacy.dao.DaoFactory;
import by.koshman.pharmacy.dao.DaoException;
import by.koshman.pharmacy.dao.DaoFactory.DaoType;
import by.koshman.pharmacy.dao.impl.DaoMySQL;
import by.koshman.pharmacy.logic.ICommand;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import by.koshman.pharmacy.logic.CommandException;
import by.koshman.pharmacy.entity.Customer;
import by.koshman.pharmacy.entity.Visit;

public class GetCustomerCommand implements ICommand {
	
	@Override
	public String execute(HttpServletRequest request) throws CommandException{
		String page = null;
		DaoMySQL dao = null;
		List<Visit> list = new ArrayList<Visit>();
		String firstName = request.getParameter(RequestParameterName.FIRST_NAME);
		String lastName = request.getParameter(RequestParameterName.LAST_NAME);
		
		try{			
			dao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.MYSQL);
			Customer customer = dao.getCustomer(firstName, lastName);
			if(customer != null){
				list = dao.getVisitList(customer.getId()); 
				request.getSession().setAttribute("cust", customer);
				request.getSession().setAttribute("list", list);
				page = JspPageName.CUSTOMER_PAGE;
			} else{
				page = JspPageName.ADD_CUSTOMER_PAGE; 
			}			
		} catch(DaoException exception){
			throw new CommandException("Cann't get DAO", exception);
		}		
		return page;
	}
}
