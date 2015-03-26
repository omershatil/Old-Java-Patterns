package partitioning.filter.push;

/**
 * The concrete filters massage the data or produce some information about the data.
 * For example, this filter converts the data into XML format and returns the 
 * number of xml tags in the data
 * Note that this kind of chaining is not very flexible, since the data format
 * has changed by the filters and you can only chain the filters in a particular
 * order! If the data format didn't changed, you could chain filters in any order!
 * @author oshatil
 *
 */
public class XmlPushFilter extends AbstractPushFilter {

	public XmlPushFilter(SinkIF filter)
	{
		super(filter);
	}
	public void putData(byte [] data)
	{
		System.out.print("XmlPushFilter is pushing data...\n");
		super.putData(data);
	}
	public int getNumXmlTags()
	{
		// fake it
		return 5;
	}
}
