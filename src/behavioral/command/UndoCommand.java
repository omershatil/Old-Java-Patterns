package behavioral.command;

public class UndoCommand extends AbstractCommand implements UndoCommandIF {
	protected boolean doIt()
	{
		throw new RuntimeException("Should never be called");
	}
	protected boolean undoIt()
	{
		throw new RuntimeException("Should never be called");
	}
}
