package structural.bridge;

public class MGMotorbikeImpl implements MotorbikeImpl {
	public void startMotion()
	{
		// to start the MG motorbike you press the gas paddle w/your feet
		// pressFeetGasForward();
		System.out.print("Moving forward with the MG motorbike using my feet\n");
	}
	public void stopMotion()
	{
		// to stop the MG car you press the break paddle w/your feet
		// pressHandBreaksForward();
		System.out.print("Stopping forward motion with the MB motorbike using my feet\n");
	}
	public void startEngine()
	{
		// stating MG engine turning the manual paddle
		// turnManuela();
		System.out.print("Starting MG motorbike engine using manual paddle");
	}
}
