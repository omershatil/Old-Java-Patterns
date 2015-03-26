package structural.bridge.abstractfactory;

import structural.bridge.*;

public class MGImplFactory implements VehicleFactoryIF {
	public BicycleImpl createBicycleImpl()
	{
		return new MGBicycleImpl();
	}
	public MotorbikeImpl createMotorbikeImpl()
	{
		return new MGMotorbikeImpl();
	}
	public CarImpl createCarImpl()
	{
		return new MGCarImpl();
	}
}
