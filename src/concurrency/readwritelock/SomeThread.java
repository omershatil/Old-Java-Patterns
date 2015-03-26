package concurrency.readwritelock;

public class SomeThread implements Runnable {
	private String name;
	private UserType type;
	private JumpersHuntersCourse course;
	
	public SomeThread(String name, UserType type, JumpersHuntersCourse course) {
		this.type = type;
		this.course = course;
		this.name = name;
	}
	public void run() {
		if (type == UserType.INSTRUCTOR) {
			// never mind the removeObstacle. Just use the add to keep it simple
			System.out.println(this.name + " is trying to add an obstacle!");
			System.out.println("If anyone is riding or changing the course, she will have to wait till riders are done...");
			try {
				course.addObstacle();
			}
			catch (InterruptedException ie) {
				
			}
			System.out.println(this.name + " is done adding the obstacle...");
		}
		else {
			// assume a rider
			System.out.println(this.name + " is trying to ride the course...");
			try {
				course.rideThrough();
			}
			catch (InterruptedException ie) {
				
			}
			System.out.println(this.name + " is done riding through. That was soooooo much fun!!!");
		}
	}
}
