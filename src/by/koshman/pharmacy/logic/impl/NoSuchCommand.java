package by.koshman.pharmacy.logic.impl;
import javax.servlet.http.HttpServletRequest;
import by.koshman.pharmacy.controller.JspPageName;
import by.koshman.pharmacy.logic.CommandException;
import by.koshman.pharmacy.logic.ICommand;

public class NoSuchCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws CommandException{
		return JspPageName.ERROR_PAGE;
	}
}
