package behavioral.command;

public class CommandFactory {
	// no need for delayed creation of the instance. It will be needed
	// for sure
	private static CommandFactory instance = new CommandFactory();
	
	private CommandFactory() {}
	
	static public CommandFactory getInstance()
	{
		return instance;
	}
	public AbstractCommand createCommand(String commandName)
	{
		if (commandName.equalsIgnoreCase("undo")){
			return new UndoCommand();
		}
		else if (commandName.equalsIgnoreCase("redo")){
			return new RedoCommand();
		}
		else if (commandName.equalsIgnoreCase("dothis")){
			return new DoThisCommand();
		}
		else if (commandName.equalsIgnoreCase("dothat")){
			return new DoThatCommand();
		}
		else if (commandName.equalsIgnoreCase("undoable")){
			return new UndoableCommand();
		}
		else {
			// TODO: throw something
		}
		return null;
	}
}
