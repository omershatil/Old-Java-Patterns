package concurrency.balking;

public class SomeThread implements Runnable {
	private Focet focet;
	
	public SomeThread(Focet focet) {
		this.focet = focet;
	}
	public void run() {
		this.focet.runWater();	
	}
}
