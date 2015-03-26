package partitioning.filter.pull;

/**
 * The abstract filter class. Chaining of filters is done via their constructors
 * and the getData() method. getData will call the filter that was passed into
 * the constructor, which is the next filter. 
 * @author oshatil
 *
 */
public abstract class AbstractPullFilter implements SourceIF {
	// private instance so that subclasses have to access it via the getData() method
	private SourceIF filter;
	
	public AbstractPullFilter(SourceIF filter)
	{
		this.filter = filter;
	}
	public byte [] getData()
	{
		return this.filter.getData();
	}
}
