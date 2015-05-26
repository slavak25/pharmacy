package by.koshman.pharmacy.logic.impl;
import java.util.List;
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
import by.koshman.pharmacy.entity.Visit;

public class GetVisitListCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws CommandException{
		String page = null;
		DaoMySQL dao = null;
		int customerId = Integer.valueOf(request.getParameter(RequestParameterName.CUSTOMER_ID));		
		
		try{			
			dao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.MYSQL);
			List<Visit> list = dao.getVisitList(customerId);		
			page = JspPageName.INDEX_PAGE;			
		} catch(DaoException exception){
			throw new CommandException("Cann't get DAO", exception);
		}		
		return page;
	}
	
}
