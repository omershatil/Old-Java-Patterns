package structural.adapter;

/**
 * This Adapter class receives a reference to its adaptee as an arg to
 * its constructor. It then delegate all requests to the adaptee. 
 * @author מרים
 *
 */public class Adapter implements CustomerInfoIF {
	private Customer customer;
	
	public Adapter(Customer customer)
	{
		this.customer = customer;
	}
	public String getCustomerName()
	{
		return this.customer.getName();
	}
	public void setCustomerName(String name)
	{
		this.customer.setName(name);
	}
}
