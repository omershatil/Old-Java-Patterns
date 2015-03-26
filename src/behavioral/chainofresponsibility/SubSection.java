package behavioral.chainofresponsibility;

/**
 * Heaters are turned on and off by each subsection. humidity is controlled
 * by the greenhouse
 * @author מרים
 *
 */
public class SubSection extends AbstractZoneComponent {
	// some zones may not have a size, so implement the size at the component
	// level, if needed
	private int zoneSize;
	
	public SubSection(String name, int zoneSize) {
		super(name);
		this.zoneSize = zoneSize;
	}
	public int getZoneSize()
	{
		return this.zoneSize;
	}
	/**
	 * if temparture is too low, activate heater in subsection. If too high,
	 * turn heater off
	 */
	public boolean handleTempChange(int temp)
	{
		if (temp > 100) {
			System.out.print("Subsection " + getName() + " turning heater OFF due to hight temparture: " + temp + "\n");
		}
		else if (temp < 60) {
			System.out.print("Subsection " + getName() + " turning heater ON due to low temparture: " + temp + "\n");
		}
		return true;
	}
}
