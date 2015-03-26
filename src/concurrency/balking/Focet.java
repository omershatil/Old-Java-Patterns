package concurrency.balking;

/**
 * I believe that the book's example of this pattern is too simplified. Check out the
 * Flusher class in this folder. The following is a more realistic implementation.
 * @author Omer Shatil
 *
 */
public class Focet {
	// this is the object that determines if the function runWater() is to balk or not.
	// If water is already running, don't run it again.
	private boolean waterRunning;
	// if the janitor sprays the sink no need for running and also, running water will 
	// wash off the chemicals, so synch those actions, so that one of them can happen but not 
	// both.
	private boolean chemicalsSprayed;
	
	public Focet() {
		this.waterRunning = false;
		this.chemicalsSprayed = false;
	}
	public boolean runWater() {
		synchronized (this) {
			if (this.waterRunning == true) {
				// indicate balking
				System.out.println("BALKING!!!");
				return false;
			}
			else {
				this.waterRunning = true;
			}
		}
		// here do the actual running of the water...
		// note that we run water even if chemicals were sprayed. that's up to the user.
		System.out.println("running water...");
		try {
			Thread.sleep(5000);
		}
		catch (InterruptedException ie) {
			
		}
		System.out.println("...done running water");
		// done. reset variable. could synch it, but not critical if don't care if 
		// sprayChemicals() doesn't spray sometimes even when it can...
		this.waterRunning = false;
		// indicate balked
		return true;
	}
	/**
	 * This method will change the status of the object (determined by the "chemicalsSprayed"
	 * property) to a status that will make it inconsistent with the idea of running water,
	 * so synch access to it
	 */
	synchronized public boolean sprayChemicals()
	{
		if (this.waterRunning == false) {
			this.chemicalsSprayed = true;
			System.out.println("Spraying Chemicals");
			return true;
		}
		System.out.println("Can't spray chemicals");
		return false;
	}
	public boolean isChemicalsSprayed() {
		return chemicalsSprayed;
	}
}
