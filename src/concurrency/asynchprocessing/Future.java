package concurrency.asynchprocessing;

public class Future {
	private boolean done = false;
	public boolean checkDone() {
		return this.done;
	}
}
