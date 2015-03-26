package structural.dynamiclinkage.loadables;

import structural.dynamiclinkage.*;

/**
 * Note that while the Environment (Omer) cannot know about this class, 
 * this class is allowed to have static references to the Environment!
 * @author מרים
 *
 */public class TypicalAmericanGirlfriend implements GirlfriendIF {
	private Omer omer;
	
	public void setOmer(Omer omer)
	{
		this.omer = omer;
	}
	public String getName()
	{
		return "StupidAmericanGirlfriend";
	}
	public void start()
	{
		System.out.print(this.omer.getLotsOfPleasure() + "\n");
		System.out.print(this.omer.getPain() + "\n");
	}
}
