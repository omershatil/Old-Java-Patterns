package partitioning.filter.pull;

/**
 * This class is the Sink of the data. It creates the Source, passes it to the 
 * filters gets it and prints it out.
 * @author oshatil
 *
 */
public class PackagingServiceSink {
	public void pullContent()
	{
		System.out.print("PackagingServiceSink pulling the data... \n");
		DDataCounterPullFilter counterPullFilter = new DDataCounterPullFilter(new RanOutOfIdeasPullFilter(new Source()));
		byte [] data = counterPullFilter.getData();
		System.out.print("PackagingServiceSink is printing the data: \n" + data.toString() + "\n");
		
	}
}
