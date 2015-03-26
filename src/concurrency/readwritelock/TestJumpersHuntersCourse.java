package concurrency.readwritelock;

import java.util.ArrayList;
import java.util.List;

public class TestJumpersHuntersCourse {
	private JumpersHuntersCourse course = new JumpersHuntersCourse();
	
	public void doIt() {
		// make sure Sarah gets to go first and make Nazar and Omer wait till she
		// sets the course. Then make Sarah wait for Namar and Omer to finish the jumps
		// before she can change the course again...
		List<Thread> threads = new ArrayList<Thread>();
		Thread t = new Thread(new SomeThread("Sarah", UserType.INSTRUCTOR, this.course));
		threads.add(t);
		t.start();
		try {
			// guarentees that Sarah gets to set course first
			Thread.sleep(2000);
		}
		catch (InterruptedException ie) {
			
		}
		t = new Thread(new SomeThread("Nazar", UserType.RIDER, this.course));
		threads.add(t);
		t.start();
		t = new Thread(new SomeThread("Omer", UserType.RIDER, this.course));
		threads.add(t);
		t.start();
		// now Cherryl wants to change the course, but she has to wait for Nazar and Omer
		// till they are done jumping. Make sure that Nazar and Omer are already riding
		// otherwise she will change the course right after Sarah changed it, since writes
		// have priority over reads.
		try {
			// guarentees that Sarah gets to set course first
			Thread.sleep(8000);
		}
		catch (InterruptedException ie) {
			
		}
		t = new Thread(new SomeThread("Cherryl", UserType.INSTRUCTOR, this.course));
		threads.add(t);
		t.start();
		// we could go on like that, but this is enough to demonstrate...
		for (int i = 0; i < threads.size(); i++) {
			try {
				threads.get(i).join();
			}
			catch (InterruptedException ie) {
				
			}
		}
	}
}
