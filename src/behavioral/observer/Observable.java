package behavioral.observer;

import java.util.*;

/**
 * Keep it simple. Have a single type of Observable. It will receive events from
 * the hardware and inform all its Observer objects. It passes
 * itself as an argument to the Observers, so that the observers can query the values
 * that have changed. The ObservableIF will expose the Observer's values via get() methods.
 * @author oshatil
 *
 */
public class Observable implements ObservableIF {
	private List<ObserverIF>observers = new ArrayList<ObserverIF>();
	private int value = 0;
	private HardwareEventGenerator hardware = new HardwareEventGenerator();
	
	public void start()
	{
		System.out.print("Value initially is set to: " + this.value + "\n");
		hardware.start();
	}
	public void addObserver(ObserverIF observer)
	{
		this.observers.add(observer);
		System.out.print("Observable added observer: " + observer.getName() + "\n");
	}
	public void removeObserver(ObserverIF observer)
	{
		this.observers.remove(observer);
		System.out.print("Observable removed observer: " + observer.getName() + "\n");
	}
	public void notifyObservers()
	{
		System.out.print("Observable is informing Observers\n");
		Iterator<ObserverIF> iter = this.observers.iterator();
		while (iter.hasNext()) {
			ObserverIF observer = iter.next();
			observer.notifyEvent(this);
		}
	}
	public int getValue() {
		return value;
	}
	/**
	 * Called by the hardware to change an observable value. Changes the value and calls
	 * notifyObservers()
	 * @param value
	 */
	private void changeValue(int value) {
		this.value = value;
		System.out.print("Value changed to: " + this.value + "\n");
		notifyObservers();
	}

	/**
	 * This class is just used to generate events that call the Observable. It simulates
	 * the hardware.
	 * @author oshatil
	 *
	 */
	private class HardwareEventGenerator {
		/**
		 * Generate hardware events
		 *
		 */
		void start()
		{
			changeValue(10);
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException ie) {
				// log and continue
			}
			changeValue(20);
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException ie) {
				// log and continue
			}
			changeValue(30);
			try {
				Thread.sleep(5000);
			}
			catch (InterruptedException ie) {
				// log and continue
			}
		}
	}
}
