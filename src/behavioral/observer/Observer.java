package behavioral.observer;

public class Observer implements ObserverIF {
	private String name;
	
	public Observer(String name, ObservableIF observable)
	{
		this.name = name;
		// register itself for events
		System.out.print("Observer " + name + " registring itself with Observable\n");
		observable.addObserver(this);
	}
	public void notifyEvent(ObservableIF observable)
	{
		System.out.print("Observer " + name + " notified of event. Value is: " + observable.getValue() + "\n");
	}
	public String getName() {
		return name;
	}
}
