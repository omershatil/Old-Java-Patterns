package structural.cachemanagement;

public class ObjectCreator implements ObjectCreatorIF {
	public SomeObject fetch(String key)
	{
		return new SomeObject(key);
	}
}
