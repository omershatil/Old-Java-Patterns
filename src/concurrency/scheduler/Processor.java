package concurrency.scheduler;

public class Processor {
	private Scheduler scheduler = new Scheduler();
	public void doIt(Request r) {
		try {
			System.out.println("Asking Schedulre to enter");
			this.scheduler.enter(r);
			System.out.println("Scheduler let me in. Doing additional work before calling done()...");
			this.scheduler.done();
		}
		catch (InterruptedException ie) {
		}
	}
}
