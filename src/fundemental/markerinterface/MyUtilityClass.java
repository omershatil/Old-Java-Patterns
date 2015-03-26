package fundemental.markerinterface;

public class MyUtilityClass {
	public void doSomething(Object o)
	{
		if (o instanceof MyMarkerInterface) {
			System.out.print("Yeepeee! This object does implement MyMarkerInterface\n");
		}
		else {
			System.out.print("Life sucks! This object does not implement MyMarkerInterface\n");
		}
	}
}
