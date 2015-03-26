package structural.bridge;

import structural.bridge.abstractfactory.*;

public class Driver {
	public void startDriving()
	{
		// create a BMW bicycle and use it.
		// first, gat a BMW factory
		VehicleFactoryIF vehicleManufacturer = null;
		ImplFactory factory = ImplFactory.getInstance();
		try {
			vehicleManufacturer = factory.getFactory(AbstractVehicleFactoryConstants.ImplType.BMW.toString());
		}
		catch (Exception e) {
			System.out.print("Failed getting factory." + e.getMessage());
		}
		Car car = new Car(vehicleManufacturer);
		car.startMotion();
		car.stopMotion();
	}
}
