package concurrency.lockobject.sameclass;

public class SomeThread implements Runnable {
	private SomeClass sc;
	
	public SomeThread(SomeClass sc) {
		this.sc = sc;
	}
	public void run() {
		sc.increment();		
	}
}
