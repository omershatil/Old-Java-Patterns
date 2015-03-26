package structural.decorator;

public class OriginalServiceB implements OriginalServiceIF {
	public void doThis()
	{
		System.out.print("OriginalServiceB doing this\n");
	}
	public void doThat()
	{
		System.out.print("OriginalServiceB doing that\n");
	}
}
