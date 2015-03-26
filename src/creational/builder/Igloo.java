package creational.builder;

public class Igloo implements HomeIF {
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
	public int getNumDoors() {
		return numDoors;
	}
	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
	}
	public int getNumWalls() {
		return numWalls;
	}
	public void setNumWalls(int numWalls) {
		this.numWalls = numWalls;
	}
	public int getNumWindows() {
		return numWindows;
	}
	public void setNumWindows(int numWindows) {
		this.numWindows = numWindows;
	}
}
