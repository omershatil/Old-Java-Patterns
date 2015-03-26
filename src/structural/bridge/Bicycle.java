package structural.bridge;

import structural.bridge.abstractfactory.VehicleFactoryIF;

/**
 * The Bicycle the simple base class of the vehicles abstraction.
 * Assume that a motorbike is a bike with an angine and that a car
 * is a bicycle with an engine and 2 extra wheels...
 * @author מרים
 *
 */
public class Bicycle {
	private BicycleImpl bicycleImpls;
	
	public Bicycle(VehicleFactoryIF vehicleManufacturer)
	{
		this.bicycleImpls = vehicleManufacturer.createBicycleImpl();
	}
	public void startMotion()
	{
		this.bicycleImpls.startMotion();
	}
	public void stopMotion()
	{
		this.bicycleImpls.stopMotion();
	}
}
