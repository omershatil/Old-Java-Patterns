package creational.builder;

/**
 * The Product of the Builder pattern in this case is the Home.
 * @author oshatil
 *
 */
public interface HomeIF {
	public BuilderConstants.CeilingType getCeilingType();
	public void setCeilingType(BuilderConstants.CeilingType ceilingType);
	public int getNumDoors();
	public void setNumDoors(int numDoors);
	public int getNumWalls();
	public void setNumWalls(int numWalls);
	public int getNumWindows();
	public void setNumWindows(int numWindows);
}
