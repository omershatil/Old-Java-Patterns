package structural.cachemanagement;

import java.util.*;
import java.lang.ref.*;

/**
 * The cache. it has a map of CacheLinkedList objects, each of which has a soft
 * reference to SomeObject. mru and lru keep track of the most/least recently used
 * items, so that when a fetch() is done the object will be quickly found. The cache size 
 * is fixed. If the cache grows beyond this fixed size every new item created causes
 * the lru item to be removed.
 * @author oshatil
 *
 */
public class Cache {
	private HashMap<String,CacheLinkedList>cache = new HashMap<String, CacheLinkedList>();
	private CacheLinkedList mru;
	private CacheLinkedList lru;
	private int curCacheSize;
	private CleanupQueue cleanupQueue;
	
	private final int CACHE_MAX_SIZE = 80;
	
	public Cache()
	{
		this.mru = null;
		this.lru = null;
		this.curCacheSize = 0;
		this.cleanupQueue = new CleanupQueue();
	}
	public void add(SomeObject o)
	{
		String id = o.getId();
		if (cache.get(id) == null) {
			// add to cache and make it mru
			if (this.curCacheSize == 0) {
				lru = mru = new CacheLinkedList(o);
			}
			else {
				CacheLinkedList newLink;
				if (this.curCacheSize >= CACHE_MAX_SIZE) {
					// remove lru object from cache
					newLink = lru;
					lru = newLink.previous;
					cache.remove(id);
					this.curCacheSize--;
					lru.next = null;
					newLink.setObject(o);
				}
				else {
					newLink = new CacheLinkedList(o);
				}
				newLink.next = mru;
				mru.previous = newLink;
				newLink.previous = null;
				mru = newLink;
			}
			// put the most recently used object in cache
			cache.put(id, this.mru);
			this.curCacheSize++;
		}
		else {
			// already in cache. do a fetch so that object becomes mru.
			fetch(id);
		}
	}
	public SomeObject fetch(String key)
	{
		// remove any ids from cache whose corresponding object has been removed by garbage collector
		this.cleanupQueue.cleanup();
		
		CacheLinkedList foundLink = (CacheLinkedList)cache.get(key);
		if (foundLink == null) {
			return null;
		}
		if (mru != foundLink) {
			if (foundLink == lru) {
				lru = foundLink.previous;
				lru.next = null;
			}
			if (foundLink.previous != null) {
				foundLink.previous.next = foundLink.next;
			}
			if (foundLink.next != null) {
				foundLink.next.previous = foundLink.next;
			}
			mru.previous = foundLink;
			foundLink.previous = null;
			foundLink.next = mru;
			mru = foundLink;
		}
		return foundLink.getObject();
	}
	public void remove(String key)
	{
		CacheLinkedList foundLink = (CacheLinkedList)cache.get(key);
		if (foundLink != null) {
			if (mru == foundLink) {
				mru = foundLink.next;
			}
			if (foundLink == lru) {
				lru = foundLink.previous;
			}
			if (foundLink.previous != null) {
				foundLink.previous.next = foundLink.next;
			}
			if (foundLink.next != null) {
				foundLink.next.previous = foundLink.previous;
			}
		}
	}
	class CacheLinkedList implements CleanUpIF 
	{
		private CacheLinkedList previous;
		private CacheLinkedList next;
		private WeakReference softRef;
		
		public CacheLinkedList(SomeObject o)
		{
			this.next = null;
			this.previous = null;
			setObject(o);
		}
		public void setObject(SomeObject o)
		{
			this.softRef = cleanupQueue.createSoftReference(o, this);
		}
		/**
		 * get the actual object by calling get() on the reference queue
		 * @return
		 */
		public SomeObject getObject()
		{
			return (SomeObject)this.softRef.get();
		}
		/**
		 * this function gets called when the cleanup queue polls for an item from
		 * the reference queue. Here all sorts of cleanup work can be done before the 
		 * object gets deleted. In this specific implementation, the object removes 
		 * itself from the cache's queue, so that there isn't an entry in the cache
		 * to an object that was already deleted
		 */
		public void cleanUp()
		{
			SomeObject o = (SomeObject)this.softRef.get();
			remove(o.getId());
		}
	}
}
