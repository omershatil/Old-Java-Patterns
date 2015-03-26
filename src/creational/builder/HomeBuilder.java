package creational.builder;

/**
 * HomeBuilder is an abstract Singleton Factory Method. However, its constructor cannot be private, 
 * since its subclasses need to be instantiated. This is not great...
 * @author oshatil
 *
 */
public abstract class HomeBuilder {
	protected HomeIF newHome;
	
	public HomeIF getNewHome() {
		return newHome;
	}
	protected HomeBuilder()
	{
	}
	public static HomeBuilder getBuilder(BuilderConstants.HomeType homeType)
	{
		if (homeType == BuilderConstants.HomeType.IGLOO) {
			return new IglooBuilder();
		}
		else if (homeType == BuilderConstants.HomeType.TEPEE) {
			return new TepeeBuilder();
		}
		else {
			// TODO: throw something
			return null;
		}
	}
	// The following 3 methods are mandatory. So, make them abstract so that
	// subclasses have to override them.
	abstract public boolean buildWalls(int numWalls);
	abstract public boolean buildDoors(int numDoors);
	abstract public boolean buildWindows(int numWindows);
	/**
	 * buildCeiling is optional so implement it and allow (but don't force)
	 * subclasses to override it.
	 * @param ceilingType
	 * @return
	 */
	public boolean buildCeiling(BuilderConstants.CeilingType ceilingType)
	{
		return true;
	}
}
