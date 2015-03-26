package partitioning.composite;

import java.util.*;

/**
 * Note that this class does NOT implement the get/set for font. Only 
 * components must implement this method. If any composite does have it
 * it would implement it in its own concrete implementation.
 * @author מרים
 *
 */public abstract class AbstractHtmlpageComposite extends AbstractHtmlpageComponent {
	private List<ComponentIF>children;
	private int cachedComponentWidth;
	private int cachedComponentHeight;
	
	public AbstractHtmlpageComposite()
	{
		this.cachedComponentHeight = -1;
		this.cachedComponentWidth = -1;
		this.children = new ArrayList<ComponentIF>();
	}
	public ComponentIF getChild(int index)
	{
		ComponentIF child = null;
		// TODO: do we need to synchronize on a get???
		synchronized (child) {
			child = children.get(index);
		}
		return child;
	}
	public void addChild(ComponentIF child)
	{
		synchronized (child) {
			this.children.add(child);
			((AbstractHtmlpageComponent)child).setParent(this);
			changeNotification();
		}
	}
	public void removeChild(AbstractHtmlpageComponent child)
	{
		synchronized (child) {
			// TODO: need to override the ComponentIF.equals() for this to work
			if (this == child.getParent()) {
				child.setParent(null);
			}
			this.children.remove(child);
			changeNotification();
		}
	}
	public void changeNotification()
	{
		this.cachedComponentHeight = -1;
		this.cachedComponentWidth = -1;
		if (getParent() != null) {
			getParent().changeNotification();
		}
	}
	/**
	 * Note that this method is implemented here and NOT in the abstract component
	 * b/c each concrete component has to implement it specifically and also, each
	 * composite needs to gather each of its children's values.
	 */
	public int getComponentPixelWidth()
	{
		if (this.cachedComponentWidth != -1) {
			return this.cachedComponentWidth;
		}
		int width = 0;
		Iterator <ComponentIF>iter = this.children.iterator();
		while (iter.hasNext()) {
			ComponentIF child = iter.next();
			width = width + child.getComponentPixelWidth();
		}
		this.cachedComponentWidth = width;
		return width;
	}
	public int getComponentPixelHeight()
	{
		if (this.cachedComponentHeight != -1) {
			return this.cachedComponentHeight;
		}
		int height = 0;
		Iterator <ComponentIF>iter = this.children.iterator();
		while (iter.hasNext()) {
			ComponentIF child = iter.next();
			height = height + child.getComponentPixelHeight();
		}
		this.cachedComponentHeight = height;
		return height;
	}
	public List<ComponentIF> getChildren() {
		return children;
	}
}
