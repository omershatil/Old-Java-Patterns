package creational.builder;

public class HomeSpecs {
	private BuilderConstants.HomeType homeType;
	private int numWalls;
	private int numDoors;
	private int numWindows;
	private BuilderConstants.CeilingType ceilingType;
	
	public BuilderConstants.CeilingType getCeilingType() {
		return ceilingType;
	}
	public void setCeilingType(BuilderConstants.CeilingType ceilingType) {
		this.ceilingType = ceilingType;
	}
	public BuilderConstants.HomeType getHomeType() {
		return homeType;
	}
	public void setHomeType(BuilderConstants.HomeType homeType) {
		this.homeType = homeType;
	}
	public int getNumDoors() {
		return numDoors;
	}
	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}
	public int getNumWindows() {
		return numWindows;
	}
	public void setNumWindows(int numWindows) {
		this.numWindows = numWindows;
	}
	public int getNumWalls() {
		return numWalls;
	}
	public void setNumWalls(int numWalls) {
		this.numWalls = numWalls;
	}
}
