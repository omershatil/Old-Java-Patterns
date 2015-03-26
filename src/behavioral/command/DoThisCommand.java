package behavioral.command;

public class DoThisCommand extends AbstractCommand {
	protected boolean doIt()
	{
		System.out.print("Doing this\n");
		return true;
	}
	protected boolean undoIt()
	{
		System.out.print("Un-Doing this\n");
		return true;
	}
}
