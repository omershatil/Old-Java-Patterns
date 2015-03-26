package behavioral.chainofresponsibility;

public abstract class AbstractZoneComponent implements ZoneIF {
	private String name;
	private AbstractZoneComposite parent;

	public AbstractZoneComponent(String name)
	{
		this.name = name;
		this.parent = null;
	}
	public AbstractZoneComposite getParent()
	{
		return this.parent;
	}
	public void setParent(AbstractZoneComposite parent)
	{
		this.parent = parent;
	}
	/**
	 * if this object doesn't handle the event, pass on to parent
	 */
	public void notifyTemp(int temp)
	{
		if (handleTempChange(temp) == false) {
			if (this.parent != null) {
				this.parent.notifyTemp(temp);
			}
		}
	}
	/**
	 * This method is to be overriden by subclasses
	 * @param temp
	 * @return
	 */
	public boolean handleTempChange(int temp)
	{
		return false;
	}
	public void notifyHumidity(int temp)
	{
		if (handleHumidityChange(temp) == false) {
			if (this.parent != null) {
				this.parent.notifyHumidity(temp);
			}
		}
	}
	/**
	 * This method is to be overriden by subclasses
	 * @param temp
	 * @return
	 */
	public boolean handleHumidityChange(int humidity)
	{
		return false;
	}
	public String getName() {
		return name;
	}
	abstract public int getZoneSize();
}
