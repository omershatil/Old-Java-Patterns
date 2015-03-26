package structural.virtualproxy;

public class Omer2 {
	public void run()
	{
		GirlfriendVirtualProxy proxy = new GirlfriendVirtualProxy();
		System.out.print(proxy.getName() + "\n");
		proxy.doSomethingForMe();
		proxy.doSomethingElseForMe();
	}
}
