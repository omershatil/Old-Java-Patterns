package concurrency.threadlocal;

public class Transaction implements Runnable {
	
	public Transaction() {
	}
	public void run() {
		// note that the second get() will return the same value as the first get()
		// that's because it's the same thread that calls that function. However,
		// 2 instances of this class will have 2 different transaction IDs
		System.out.println("Running Transaction ID: " + TransactionID.get());
		System.out.println("Done running Transaction ID: " + TransactionID.get());
	}
}
