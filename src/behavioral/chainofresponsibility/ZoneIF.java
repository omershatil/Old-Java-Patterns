package behavioral.chainofresponsibility;

public interface ZoneIF {
	public String getName();
	public AbstractZoneComposite getParent();
	// some zones may not have a size, so implement the size at the component
	// level, if needed
	public int getZoneSize();
	public void notifyTemp(int temp);
	public void notifyHumidity(int temp);
}
