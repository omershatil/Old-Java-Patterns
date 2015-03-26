package structural.bridge;

import structural.bridge.abstractfactory.VehicleFactoryIF;

/**
 * A car is a bicycle with an engine and a couple of more wheels
 * @author מרים
 *
 */
public class Car extends Bicycle {
	private CarImpl carImpl;
	
	public Car(VehicleFactoryIF vehicleManufacturer)
	{
		// NOTE: this is wrong. The relationshipe between car/bike/motorbike doesn't fit here
		// perfectly
		super(vehicleManufacturer);
		this.carImpl = vehicleManufacturer.createCarImpl();
	}
	public void startMotion()
	{
		this.carImpl.shutDoors();
		this.carImpl.startEngine();
		this.carImpl.startMotion();
	}
	public void stopMotion()
	{
		this.carImpl.stopMotion();
	}
}
