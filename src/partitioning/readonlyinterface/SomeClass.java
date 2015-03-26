package partitioning.readonlyinterface;

/**
 * This class implements the mutator methods
 * @author מרים
 *
 */
public class SomeClass implements SomeIF {
	private String someStringValue;
	
	public SomeClass()
	{
		this.someStringValue = "";
	}
	public SomeClass(String str)
	{
		this.someStringValue = str;
	}
	
	public void setSomeStringValue(String str) {
		System.out.print("Setting the following string: " + str);
		this.someStringValue = str;
	}

	public String getSomeStringValue()
	{
		System.out.print("Getting the following string: " + this.someStringValue);
		return this.someStringValue;
	}
}
