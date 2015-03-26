package structural.decorator;

public class OriginalServiceA implements OriginalServiceIF {
	public void doThis()
	{
		System.out.print("OriginalServiceA doing this\n");
	}
	public void doThat()
	{
		System.out.print("OriginalServiceA doing that\n");
	}
}
