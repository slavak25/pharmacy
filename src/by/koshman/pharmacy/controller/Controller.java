package by.koshman.pharmacy.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.koshman.pharmacy.logic.CommandException;
import by.koshman.pharmacy.logic.CommandHelper;
import by.koshman.pharmacy.logic.ICommand;

public class Controller extends HttpServlet{
	private static final long serialVersionUID = 1l;
	
	public Controller(){
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException,IOException{
		
		String commandName = request.getParameter(RequestParameterName.COMMAND_NAME);
		
		ICommand command = CommandHelper.getInstance().getCommand(commandName);
		String page = null;
		
		try{
			page = command.execute(request);			
		} catch (CommandException exception){
			page = JspPageName.INDEX_PAGE;
		} catch (Exception exception){			
			exception.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		
		if(dispatcher != null){
			dispatcher.forward(request, response);
		} else{
			errorMessageDireclyFromResponse(response);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException,IOException{}
	
	 private void errorMessageDireclyFromResponse(HttpServletResponse response)
 throws IOException{
		 response.setContentType("text/html");
		 response.getWriter().println("ERROR");
	 }	 	
}
