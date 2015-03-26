package structural.bridge;

public class BmwCarImpl implements CarImpl {
	public void startMotion()
	{
		// to start the bmw car you press the gas paddle w/your hands (crazy Germans)
		// pressHandGasForward();
		System.out.print("Moving forward with the BMW car using my hands\n");
	}
	public void stopMotion()
	{
		// to stop the bmw car you press the break paddle w/your hands (crazy Germans)
		// pressHandBreaksForward();
		System.out.print("Stopping forward motion with the BMW car using my hands\n");
	}
	public void startEngine()
	{
		// stating bmw engine turning the manuela
		// turnManuela();
		System.out.print("Starting BMW engine using manuela\n");
	}
	public void shutDoors()
	{
		// shut door from right to left
		// shutDoorRightToLeft();
		System.out.print("Shutting BMW door from right to left\n");
	}
}
