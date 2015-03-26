package partitioning.filter.pull;

/**
 * The concrete filters massage the data or produce some information about the data.
 * For example, this filter should do something, but I ran out of ideas, so it does nothing.
 * 
 * @author oshatil
 *
 */
public class RanOutOfIdeasPullFilter extends AbstractPullFilter {
	public RanOutOfIdeasPullFilter(SourceIF filter)
	{
		super(filter);
	}
	public byte [] getData()
	{
		System.out.print("RanOutOfIdeasPullFilter is pulling data...\n");
		return super.getData();
	}
}
