package structural.virtualproxy.loadables;

import structural.virtualproxy.*;

public class TypicalAmericanGirlfriend implements GirlfriendIF {
	
	public String getName()
	{
		return "StupidAmericanGirlfriend";
	}
	public void doSomethingForMe()
	{
		System.out.print("I am doing this for you, honey\n");
	}
	public void doSomethingElseForMe()
	{
		System.out.print("I am doing this ALSO for you, honey\n");
	}
}
