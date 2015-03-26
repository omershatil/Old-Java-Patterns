package behavioral.chainofresponsibility;

public class Greenhouse extends AbstractZoneComposite {
	private int zoneSize;
	
	public Greenhouse(String name, int zoneSize) {
		super(name);
		this.zoneSize = zoneSize;
	}
	public int getZoneSize()
	{
		return this.zoneSize;
	}
	/**
	 * if humidity is too low even in one subsection turn on irrigation in 
	 * the whole greenhouse. If too high, stop irrigation
	 */
	public boolean handleHumidityChange(int humidity)
	{
		if (humidity > 100) {
			System.out.print("Subsection " + getName() + " turning irrigation OFF due to high humidity: " + humidity + "\n");
		}
		else if (humidity < 60) {
			System.out.print("Subsection " + getName() + " turning irrigation ON due to low humidity: " + humidity + "\n");
		}
		return true;
	}
}
