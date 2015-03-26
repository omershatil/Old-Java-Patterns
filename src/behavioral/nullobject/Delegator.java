package behavioral.nullobject;

public class Delegator {
	public void routeMessage(OperationIF op)
	{
		// no matter what kind of message it is, always route it.
		String msg = getMessageToDelegate();
		op.doSomething(msg);
	}
	private String getMessageToDelegate()
	{
		return "message";
	}
}
