package structural.bridge;

public class BmwBicycleImpl implements BicycleImpl {
	public void startMotion()
	{
		// to start the bmw bike you paddle w/your hands forwards (crazy Germans)
		// handPaddleForward();
		System.out.print("Paddling the bmw bike using my hands\n");
	}
	public void stopMotion()
	{
		// to stop the bmw bike you paddle w/your hands backwards (crazy Germans)
		// handPaddleBackwards();
		System.out.print("Stopping the bmw bike using my hands\n");
	}
}
