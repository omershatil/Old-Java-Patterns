package behavioral.observer;

public interface ObservableIF {
	public void addObserver(ObserverIF observer);
	public void removeObserver(ObserverIF observer);
	public int getValue();
}
