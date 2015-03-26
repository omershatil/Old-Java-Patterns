package structural.bridge;

import structural.bridge.abstractfactory.VehicleFactoryIF;

public class Motorbike extends Bicycle {
	private MotorbikeImpl motorbikeImpl;
	
	// NOTE: this is wrong. The relationshipe between car/bike/motorbike doesn't fit here
	// perfectly
	public Motorbike(VehicleFactoryIF vehicleManufacturer)
	{
		super(vehicleManufacturer);
		this.motorbikeImpl = vehicleManufacturer.createMotorbikeImpl();
	}
	public void startMotion()
	{
		this.motorbikeImpl.startMotion();
	}
	public void stopMotion()
	{
		this.motorbikeImpl.stopMotion();
	}
}
