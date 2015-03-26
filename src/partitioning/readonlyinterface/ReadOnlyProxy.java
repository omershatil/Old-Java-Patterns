package partitioning.readonlyinterface;

public class ReadOnlyProxy implements SomeIF {
	private SomeClass someClass;
	
	public ReadOnlyProxy()
	{
		this.someClass = new SomeClass("Some string in a read only class\n");
	}
	public String getSomeStringValue()
	{
		return this.someClass.getSomeStringValue();
	}
}
