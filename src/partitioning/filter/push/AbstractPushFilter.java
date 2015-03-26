package partitioning.filter.push;

/**
 * The abstract filter class. Chaining of filters is done via their constructors
 * and the putData() method. putData will call the filter that was passed into
 * the constructor, which is the next filter. 
 * @author oshatil
 *
 */
public abstract class AbstractPushFilter implements SinkIF {
	// private instance so that subclasses have to access it via the putData() method
	private SinkIF filter;
	
	public AbstractPushFilter(SinkIF filter)
	{
		this.filter = filter;
	}
	public void putData(byte [] data)
	{
		this.filter.putData(data);
	}
}
