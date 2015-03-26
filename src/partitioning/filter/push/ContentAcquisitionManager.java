package partitioning.filter.push;

/**
 * This class is the source of the data. It reads a "feed" into a stream and 
 * passes it on to an (internal) XML filter which converts the stream into an 
 * internal known XML representation. Then a second filter will convert the XML
 * data to DData and will call the Sink to save the data as a file on disk.
 * @author oshatil
 *
 */
public class ContentAcquisitionManager {
	public void pushContent()
	{
		// note the chaining
		XmlPushFilter xmlPushFilter = new XmlPushFilter(new DDataPushFilter(new Sink()));
		// push the data all the way to the sink
		System.out.print("ContentAcquisitionManager read data and is pushing data...\n");
		xmlPushFilter.putData("Just some text data".getBytes());
	}
}
