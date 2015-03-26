package creational.objectpool.soft;

import creational.objectpool.*;

import java.util.*;
import java.lang.ref.*;

/**
 * 
 * @author oshatil
 *
 */
public class SoftObjectPool {
	private List<SoftReference>pool;
	// The following counters are for allowed number of objects in the system: in the 
	// pool and in use
	private int currObjectCount;
	private int maxObjectCount;
	// the class of the object to be managed in the pool
	private Class reusableClass; 
	private ReusableCreator creator;
	
	public SoftObjectPool(Class reusableClass, ReusableCreator creator, int maxObjectCount)
	{
		this.reusableClass = reusableClass;
		this.maxObjectCount = maxObjectCount;
		this.currObjectCount = 0;
		this.pool = new ArrayList<SoftReference>();
		this.creator = creator;
	}
	/**
	 * Return an object to the pool.
	 *
	 */
	public void releaseReusable(Object obj) throws Exception
	{
		if (this.reusableClass.isInstance(obj) == false) {
			throw new Exception();
		}
		synchronized (this.pool) {
			this.pool.add(new SoftReference<Object>(obj));
			this.pool.notify();
		}
	}
	/**
	 * Get a reusable. If maxObjectCount was acceded, wait till an object is available.
	 * @return
	 */
	public Object waitForReusable()
	{
		Object obj = null;
		synchronized (this.pool) {
			do {
				obj = acquireReusable();
				try {
					this.pool.wait();
				}
				catch (InterruptedException ie) {
					
				}
				obj = acquireReusable();
			} while(obj == null);
		}
		return obj;
	}
	/**
	 * get an object from the pool. If pool is empty, create a new object, but only
	 * if there haven't acceded maxObjectCount.
	 * @return
	 */
	public Object acquireReusable()
	{
		SoftReference ref = null;
		synchronized (this.pool) {
			// if pool is empty and haven't passed the number of allowed objects, create a new one
			if (this.pool.size() == 0) {
				if (this.currObjectCount == this.maxObjectCount) {
					return null;
				}
				ref = new SoftReference<Object>(this.creator.create());
				this.currObjectCount = this.currObjectCount + 1;
				return ref.get();
			}
			// attempt to find a soft reference that hasn't lost its object
			Iterator <SoftReference>iter = this.pool.iterator();
			while (iter.hasNext()) {
				ref = iter.next();
				if (ref.get() != null) {
					this.pool.remove(ref);
					return ref.get();
				}
			}
			// take a soft reference from the pool and create a reusable object for it
			this.pool.remove(0);
			ref = new SoftReference<Object>(this.creator.create());
			return ref.get();
		}
	}
	public int getCurrObjectCount() {
		return currObjectCount;
	}
	public void setCurrObjectCount(int currObjectCount) {
		this.currObjectCount = currObjectCount;
	}
	public int getMaxObjectCount() {
		return maxObjectCount;
	}
	public void setMaxObjectCount(int maxObjectCount) {
		this.maxObjectCount = maxObjectCount;
	}
	public int getPoolSize() {
		return this.pool.size();
	}
}
