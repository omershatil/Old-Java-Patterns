package behavioral.visitor.ideal;

import java.util.*;

/** all comments relate to the Visitor. For Composite comments see the Composite pattern
 * 
 * @author oshatil
 *
 */
public abstract class AbstractCompositeIdeal extends AbstractComponentIdeal {
	private List<ComponentIdealIF>children;
	private int cachedComponentWidth;
	private int cachedComponentHeight;
	
	/**
	 * Allow visitor to visit and then pass visitor down to the next child. This 
	 * will cause traversal all the way down the composite tree to all components.
	 * @param visitor
	 */
	public void accept(VisitorIF visitor) {
		super.accept(visitor);
		for (ComponentIdealIF child : this.children) {
			child.accept(visitor);
		}
	}
	public AbstractCompositeIdeal()
	{
		this.cachedComponentHeight = -1;
		this.cachedComponentWidth = -1;
		this.children = new ArrayList<ComponentIdealIF>();
	}
	public ComponentIdealIF getChild(int index)
	{
		ComponentIdealIF child = null;
		synchronized (child) {
			child = children.get(index);
		}
		return child;
	}
	public void addChild(ComponentIdealIF child)
	{
		synchronized (child) {
			this.children.add(child);
			((AbstractComponentIdeal)child).setParent(this);
			changeNotification();
		}
	}
	public void removeChild(AbstractComponentIdeal child)
	{
		synchronized (child) {
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
	public List<ComponentIdealIF> getChildren() {
		return children;
	}
}
