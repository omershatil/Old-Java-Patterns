package behavioral.nullobject;

public class RealOperation implements OperationIF {
	public void doSomething(String token)
	{
		System.out.print("Doing something with this token: " + token + "\n");
	}
}
