package structural.bridge;

public class MGBicycleImpl implements BicycleImpl{
	public void startMotion()
	{
		// to start the gm bike you paddle w/your feet forwards 
		// feetPaddleForward();
		System.out.print("GMBicycleImpl starting motion\n");
	}
	public void stopMotion()
	{
		// to stop the mg bike you paddle w/your feet backwards 
		// handPaddleBackwards();
		System.out.print("GMBicycleImpl stopping motion\n");
	}

}
