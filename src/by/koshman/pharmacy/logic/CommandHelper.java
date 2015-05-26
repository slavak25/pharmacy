package by.koshman.pharmacy.logic;
import java.util.HashMap;
import java.util.Map;

import by.koshman.pharmacy.entity.Customer;
import by.koshman.pharmacy.logic.impl.GetCustomerCommand;
import by.koshman.pharmacy.logic.impl.GetVisitListCommand;
import by.koshman.pharmacy.logic.impl.AddCustomerCommand;
import by.koshman.pharmacy.logic.impl.AddVisitCommand;
import by.koshman.pharmacy.logic.impl.UpdateVisitCommand;
import by.koshman.pharmacy.logic.impl.DeleteVisitCommand;
import by.koshman.pharmacy.logic.impl.NoSuchCommand;

public final class CommandHelper {
	private static final CommandHelper instance = new CommandHelper();
	private Map<CommandName, ICommand> commands = new HashMap();
	
	public CommandHelper(){
		commands.put(CommandName.GET_CUSTOMER_COMMAND, new GetCustomerCommand());
		commands.put(CommandName.GET_VISIT_LIST_COMMAND, new GetVisitListCommand());
		commands.put(CommandName.ADD_CUSTOMER_COMMAND, new AddCustomerCommand());
		commands.put(CommandName.ADD_VISIT_COMMAND, new AddVisitCommand());
		commands.put(CommandName.UPDATE_VISIT_COMMAND, new UpdateVisitCommand());
		commands.put(CommandName.DELETE_VISIT_COMMAND, new DeleteVisitCommand());
		
	}
	
	public static CommandHelper getInstance(){
		return instance;
	}
	
	public ICommand getCommand(String commandName){
		CommandName name = CommandName.valueOf(commandName.toUpperCase());
		ICommand command;
		if(null != name){
			command = commands.get(name);			
		} else{
			command = commands.get(CommandName.NO_SUCH_COMMAND);
		}
		return command;
	}
}
