package behavioral.observer;

public interface ObserverIF {
	public void notifyEvent(ObservableIF observable);
	public String getName();
}
