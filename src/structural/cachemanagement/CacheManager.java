package structural.cachemanagement;

/**
 * implements the same interface as the ObjectCreator, so that if it was developed
 * late in the development cycle it can be plugged in to replace the ObjectCreator
 * transparantly (using virtual proxy).
 * @author oshatil
 *
 */
public class CacheManager implements ObjectCreatorIF {
	private Cache cache;
	private ObjectCreator objectCreator;

	public CacheManager()
	{
		this.cache = new Cache();
		this.objectCreator = new ObjectCreator();
	}
	/**
	 * if object is not in cache, create it and add it to cache.
	 */
	public SomeObject fetch(String key)
	{
		SomeObject o = cache.fetch(key);
		if (o == null) {
			o = objectCreator.fetch(key);
			if (o != null) {
				this.cache.add(o);
			}
		}
		return o;
	}
}
