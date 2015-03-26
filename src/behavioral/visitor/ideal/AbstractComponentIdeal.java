package behavioral.visitor.ideal;

/** all comments relate to the Visitor. For Composite comments see the Composite pattern
 * 
 * @author oshatil
 *
 */
public abstract class AbstractComponentIdeal implements ComponentIdealIF {
	private int font;
	private AbstractCompositeIdeal parent;
	
	/**
	 * Allow visitor to visit and then pass visitor down to the next child. This 
	 * will cause traversal all the way down the composite tree to all components.
	 * @param visitor
	 */
	public void accept(VisitorIF visitor) {
		visitor.visit(this);
	}
	public AbstractComponentIdeal()
	{
		this.parent = null;
		this.font = -1;
	}
	public AbstractCompositeIdeal getParent()
	{
		return this.parent;
	}
	public void setParent(AbstractCompositeIdeal parent)
	{
		this.parent = parent;
	}
	public int getFont()
	{
		if (this.font > -1) {
			return this.font;
		}
		if (getParent() != null) {
			return getParent().getFont();
		}
		return -1;
	}
	public void setFont(int font)
	{
		this.font = font;
	}
}
