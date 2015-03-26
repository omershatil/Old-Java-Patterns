package structural.bridge.abstractfactory;

import structural.bridge.*;

public interface VehicleFactoryIF {
	public BicycleImpl createBicycleImpl();
	public MotorbikeImpl createMotorbikeImpl();
	public CarImpl createCarImpl();
}
