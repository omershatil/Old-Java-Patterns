package concurrency.scheduler;

public class SomeThread implements Runnable {
	private Processor p;
	
	public SomeThread(Processor p) {
		this.p = p;
	}
	public void run() {
		Request r = new Request();
		this.p.doIt(r);	
	}
}
