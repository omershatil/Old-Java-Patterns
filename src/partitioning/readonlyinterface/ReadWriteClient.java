package partitioning.readonlyinterface;

/**
 * this client can call "set" methods on the SomeIF object
 * @author מרים
 *
 */
public class ReadWriteClient {
	public void writeString(String str)
	{
		ReadWriteProxy proxy = new ReadWriteProxy();
		proxy.setSomeStringValue(str);
	}
}
