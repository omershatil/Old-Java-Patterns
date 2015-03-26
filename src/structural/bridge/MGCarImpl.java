package structural.bridge;

public class MGCarImpl implements CarImpl {
	public void startMotion()
	{
		// to start the GM car you press the gas paddle w/your feet
		// pressFeetGasForward();
		System.out.print("Moving forward with the GM car using my feet\n");
	}
	public void stopMotion()
	{
		// to stop the GM car you press the break paddle w/your feet
		// pressHandBreaksForward();
		System.out.print("Stopping forward motion with the GM car using my feet\n");
	}
	public void startEngine()
	{
		// stating MG engine turning the manuela
		// turnManuela();
		System.out.print("Starting MG engine using manuela");
	}
	public void shutDoors()
	{
		// shut door from left to right
		// shutDoorLeftToRight();
		System.out.print("Shutting MG door from left to right");
	}
}
