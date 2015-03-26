package structural.virtualproxy;

public class GirlfriendVirtualProxy implements GirlfriendIF {
	private GirlfriendIF girlfriend;
	
	public GirlfriendVirtualProxy()
	{
		// load a couple of girlfriends, use them and dump them
		Class girlfriendClass = null;
		try {
			// try 2 ways to load classes: URL and forName
			girlfriendClass = Class.forName("structural.virtualproxy.loadables.TypicalAmericanGirlfriend");
			girlfriend = (GirlfriendIF)girlfriendClass.newInstance();
		}
		catch (ClassNotFoundException cnfe) {
			
		}
		catch (IllegalAccessException iae) {
			
		}
		catch (InstantiationException iae) {
			
		}
	}

	public void doSomethingForMe()
	{
		this.girlfriend.doSomethingForMe();
	}
	public void doSomethingElseForMe()
	{
		this.girlfriend.doSomethingElseForMe();
	}
	public String getName()
	{
		return this.girlfriend.getName();
	}
}
