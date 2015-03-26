package partitioning.composite;

/**
 * Contrary to the usual principle of low coupling and high cohesion, 
 * methods that are needed by any concrete component class will be defined 
 * in ComponentIF. This is because the main benefit of the Composite pattern 
 * is to allow clients and the objects that constitute the Composite 
 * pattern to be unaware of the specific class of the objects they deal with 
 * @author מרים
 *
 */
public interface ComponentIF {
	public AbstractHtmlpageComposite getParent();
	// NOTE: The interface is accessed by the outside world, so it should not 
	// expose the setParent method! setMethod is implemented in the AbstractHtmlpageComponent
	// class which all objects extend
	//public void setParent(AbstractHtmlpageComposite parent);
	public int getFont();
	public CompositeConstants.ImageType getImageType();
	public int getComponentPixelWidth();
	public int getComponentPixelHeight();
	
	public void print(); 
}
