package behavioral.command;

public class RedoCommand extends AbstractCommand implements RedoCommandIF {
	protected boolean doIt()
	{
		throw new RuntimeException("Should never be called");
	}
	protected boolean undoIt()
	{
		throw new RuntimeException("Should never be called");
	}
}
