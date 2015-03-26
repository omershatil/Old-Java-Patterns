package partitioning.composite;

/**
 * Implements the get/set of a parent. Note that the setParent is not defined
 * in the interface, since it shouldn't be accessed by clients
 * @author מרים
 *
 */
public abstract class AbstractHtmlpageComponent implements ComponentIF {
	private int font;
	private AbstractHtmlpageComposite parent;
	
	public AbstractHtmlpageComponent()
	{
		this.parent = null;
		this.font = -1;
	}
	public AbstractHtmlpageComposite getParent()
	{
		return this.parent;
	}
	public void setParent(AbstractHtmlpageComposite parent)
	{
		this.parent = parent;
	}
	/**
	 * If it has its own font, return it. If not see delegate to parent.
	 */
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
