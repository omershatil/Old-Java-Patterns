package concurrency.readwritelock;

/** An obstacle course for horses. Contains a single variable for number of 
 * obstacles. Access to this variable is controlled by the Read/Write lock.
 * When the instructor changes the course (adds/removes an obstacle), the
 * riders cannot ride through. When any rider is riding through, the instructor
 * cannot change the course until the last rider is done.
 * This pattern allows a better throughput in the case that there is a single
 * instructor who infrequently changes the course ("write" operation), and there 
 * are many riders who need to ride through the course ("read" operation).
 * @author Omer Shatil
 *
 */
public class JumpersHuntersCourse {
	private int numObstacles = 0;
	private ReadWriteLock lock = new ReadWriteLock();
	
	public void addObstacle() throws InterruptedException {
		lock.writeLock();
		// to simulate the adding of an obstacle, sleep 8 seconds
		System.out.println("Adding obstacle now...");
		Thread.sleep(8000);
		this.numObstacles = this.numObstacles + 1;
		lock.done();
	}
	public void removeObstacle() throws InterruptedException {
		lock.writeLock();
		// to simulate the removing of an obstacle, sleep 8 seconds
		System.out.println("Removing obstacle now...");
		Thread.sleep(8000);
		this.numObstacles = this.numObstacles - 1;
		lock.done();
	}
	public void rideThrough() throws InterruptedException {
		lock.readLock();
		// to simulate a ride through sleep for 5 second
		System.out.println("Riding the course now! Whooooooohhhhoooooo!!!!!!");
		Thread.sleep(5000);
		lock.done();
	}
}
