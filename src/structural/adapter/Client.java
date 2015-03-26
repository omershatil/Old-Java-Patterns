package structural.adapter;

/**
 * The client knows of the Adapter, but not of the adaptee. This is why 
 * it receives an Adapter object which implements the interface the client needs, 
 * but doesn't know hot to create it.
 * @author מרים
 *
 */public class Client {
	private CustomerInfoIF adapter;
	
	public Client(CustomerInfoIF adapter)
	{
		this.adapter = adapter;
	}
	public void doYourThing()
	{
		this.adapter.setCustomerName("Some Name");
		System.out.print("Customer name: " + this.adapter.getCustomerName() + "\n");
	}
}
