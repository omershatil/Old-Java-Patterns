package structural.cachemanagement;

public class CacheClient {
	public void useCache()
	{
		CacheManager cacheManager = new CacheManager();
		SomeObject x = cacheManager.fetch("x");
		SomeObject y = cacheManager.fetch("y");
		SomeObject z = cacheManager.fetch("z");
		x = cacheManager.fetch("x");
		// try to run out of memory to force the vm to delete some soft references
/*		while (true) {
			long l = 0;
			cacheManager.fetch(new Long(l++).toString());
		}
*/	}
}
