package structural.cachemanagement;

public class CacheObjectClient {
	private ObjectCreatorIF cacheManager;
	
	public CacheObjectClient()
	{
		this.cacheManager = new CacheManager();
	}
	public Object fetch(String key)
	{
		return this.cacheManager.fetch(key);
	}
}
