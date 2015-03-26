package structural.dynamiclinkage;

import java.net.*;

public class Omer {
	public void run()
	{
		// load a couple of girlfriends, use them and dump them
		Class girlfriend = null;
		try {
			// try 2 ways to load classes: URL and forName
			girlfriend = Class.forName("structural.dynamiclinkage.loadables.TypicalAmericanGirlfriend");
			GirlfriendIF girlfriend1 = (GirlfriendIF)girlfriend.newInstance();
			girlfriend1.setOmer(this);
			girlfriend1.start();
		}
		catch (ClassNotFoundException cnfe) {
			
		}
		catch (IllegalAccessException iae) {
			
		}
		catch (InstantiationException iae) {
			
		}
	}
	public String getLotsOfPleasure()
	{
		return "fun, fun, fun";
	}
	public String getPain()
	{
		return "que pena";
	}
}
