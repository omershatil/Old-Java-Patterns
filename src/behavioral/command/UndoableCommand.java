package behavioral.command;

public class UndoableCommand extends AbstractCommand {
	protected boolean doIt()
	{
		System.out.print("Doing The Undoable\n");
		// return false, 'cause it's not undoable
		return false;
	}
	protected boolean undoIt()
	{
		// but it's undoable!
		throw new RuntimeException("Should never be called");
	}
}
