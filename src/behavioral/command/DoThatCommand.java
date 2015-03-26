package behavioral.command;

public class DoThatCommand extends AbstractCommand {
	protected boolean doIt()
	{
		System.out.print("Doing that\n");
		return true;
	}
	protected boolean undoIt()
	{
		System.out.print("Un-Doing that\n");
		return true;
	}
}
