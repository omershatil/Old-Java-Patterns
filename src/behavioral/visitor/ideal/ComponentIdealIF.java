package behavioral.visitor.ideal;

/** all comments relate to the Visitor. For Composite comments see the Composite pattern
 * 
 * @author oshatil
 *
 */
public interface ComponentIdealIF {
	// each component (and as a result, each composite) should have the accept() method
	public void accept(VisitorIF visitor);
	public AbstractCompositeIdeal getParent();
	public int getFont();
	public String getImageType();
	public int getComponentPixelWidth();
	public int getComponentPixelHeight();
	
	public void print(); 
}
