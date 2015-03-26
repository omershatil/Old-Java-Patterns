package creational.builder;

public class IglooBuilder extends HomeBuilder {
	protected IglooBuilder()
	{
		this.newHome = new Igloo();
	}
	public boolean buildWalls(int numWalls)
	{
		this.newHome.setNumWalls(numWalls);
		return true;
	}
	public boolean buildDoors(int numDoors)
	{
		this.newHome.setNumDoors(numDoors);
		return true;
	}
	public boolean buildWindows(int numWindows)
	{
		this.newHome.setNumWindows(numWindows);
		return true;
	}
	public boolean buildCeiling(BuilderConstants.CeilingType ceilingType)
	{
		this.newHome.setCeilingType(ceilingType);
		return true;
	}
}
