package partitioning.readonlyinterface;

public class ReadWriteProxy implements SomeIF {
	private SomeClass someClass;
	
	public ReadWriteProxy()
	{
		this.someClass = new SomeClass();
	}
	public String getSomeStringValue()
	{
		return this.someClass.getSomeStringValue();
	}
	public void setSomeStringValue(String str)
	{
		this.someClass.setSomeStringValue(str);
	}
}
