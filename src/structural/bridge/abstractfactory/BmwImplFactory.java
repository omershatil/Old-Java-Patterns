package structural.bridge.abstractfactory;

import structural.bridge.*;

public class BmwImplFactory implements VehicleFactoryIF {
	public BicycleImpl createBicycleImpl()
	{
		return new BmwBicycleImpl();
	}
	public MotorbikeImpl createMotorbikeImpl()
	{
		return new BmwMotorbikeImpl();
	}
	public CarImpl createCarImpl()
	{
		return new BmwCarImpl();
	}
}
