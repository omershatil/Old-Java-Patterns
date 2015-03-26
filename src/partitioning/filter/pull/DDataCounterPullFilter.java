package partitioning.filter.pull;

/**
 * The concrete filters massage the data or produce some information about the data.
 * For example, this filter counts the number of ddata entries.
 * 
 * @author oshatil
 *
 */
public class DDataCounterPullFilter extends AbstractPullFilter {
	public DDataCounterPullFilter(SourceIF filter)
	{
		super(filter);
	}
	public byte [] getData()
	{
		System.out.print("DDataCounterPullFilter is pulling data...\n");
		return super.getData();
	}
}
