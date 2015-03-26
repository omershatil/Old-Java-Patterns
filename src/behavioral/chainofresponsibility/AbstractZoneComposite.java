package behavioral.chainofresponsibility;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractZoneComposite extends AbstractZoneComponent {
	private List<ZoneIF>children;
	
	public AbstractZoneComposite(String name)
	{
		super(name);
		this.children = new ArrayList<ZoneIF>();
	}
	public ZoneIF getChild(int index)
	{
		ZoneIF child = null;
		// TODO: do we need to synchronize on a get???
		synchronized (child) {
			child = children.get(index);
		}
		return child;
	}
	public void addChild(ZoneIF child)
	{
		synchronized (child) {
			this.children.add(child);
			((AbstractZoneComponent)child).setParent(this);
		}
	}
	public void removeChild(AbstractZoneComponent child)
	{
		synchronized (child) {
			// TODO: need to override the ComponentIF.equals() for this to work
			if (this == child.getParent()) {
				child.setParent(null);
			}
			this.children.remove(child);
		}
	}
	public int getZoneSize()
	{
		int width = 0;
		Iterator <ZoneIF>iter = this.children.iterator();
		while (iter.hasNext()) {
			ZoneIF child = iter.next();
			width = width + child.getZoneSize();
		}
		return width;
	}
	public List<ZoneIF> getChildren() {
		return children;
	}
}
