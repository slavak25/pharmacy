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
public class DeleteVisitCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws CommandException{
		String page = null;
		DaoMySQL dao = null;		
		int id = Integer.valueOf(request.getParameter(RequestParameterName.VISIT_ID));
				
		try{			
			dao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.MYSQL);
			dao.deleteVisit(id);			
			page = JspPageName.RESPONSE_PAGE;			
		} catch(DaoException exception){
			throw new CommandException("Cann't get DAO", exception);
		}		
		return page;
	}

}
