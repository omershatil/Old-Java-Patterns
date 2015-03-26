package behavioral.chainofresponsibility;

/**
 * Sensor simply informs its assigned zone of a change in humidity and temparture
 * @author מרים
 *
 */
public class Sensor implements SensorIF {
	// The zone for which the sensor receives readings
	public ZoneIF zone;
	
	public Sensor(ZoneIF zone)
	{
		this.zone = zone;
	}
	public void notifyTemp(int temp)
	{
		this.zone.notifyTemp(temp);
	}
	public void notifyHumidity(int humidity)
	{
		this.zone.notifyHumidity(humidity);
	}
}
