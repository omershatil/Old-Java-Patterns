package partitioning.readonlyinterface;

/**
 * the only method that this client call on the SomeIF object
 * is the "get" method. it cannot set any values
 * @author מרים
 *
 */
public class ReadOnlyClient {
	public void readString()
	{
		ReadOnlyProxy proxy = new ReadOnlyProxy();
		String str = proxy.getSomeStringValue();
	}
}
