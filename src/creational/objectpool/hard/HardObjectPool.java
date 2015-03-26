package creational.objectpool.hard;

import creational.objectpool.*;

import java.util.*;
import java.lang.ref.*;
import java.lang.reflect.*;

/**
 * 
 * @author oshatil
 *
 */
public class HardObjectPool {
	private Object [] pool;
	// The following counters are for allowed number of objects in the system: in the 
	// pool and in use
	private int currObjectCount;
	private int maxObjectCount;
	// fixed size pool
	private int currPoolSize;
	private int maxPoolSize;
	// the class of the object to be managed in the pool
	private Class reusableClass; 
	private ReusableCreator creator;
	
	public HardObjectPool(Class reusableClass, ReusableCreator creator, int maxObjectCount, int maxPoolSize)
	{
		this.reusableClass = reusableClass;
		this.maxObjectCount = maxObjectCount;
		this.currObjectCount = 0;
		// use reflection Array to get a new instance
		this.pool = (Object [])Array.newInstance(reusableClass, maxPoolSize);
		//this.pool = new Object[maxPoolSize];
		this.currPoolSize = 0;
		this.maxPoolSize = maxPoolSize;
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
			if (this.currPoolSize < this.maxPoolSize) {
				// return object to pool
				this.pool[this.currPoolSize++] = obj;
				this.pool.notify();
			}
			else {
				// let object go and release external resources
				this.creator.release(obj);
				this.currObjectCount--;
			}
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
		Object obj = null;
		synchronized (this.pool) {
			// if pool is empty and haven't passed the number of allowed objects, create a new one
			if (this.currPoolSize == 0) {
				if (this.currObjectCount == this.maxObjectCount) {
					return null;
				}
				obj = this.creator.create();
				this.currObjectCount++;
				return obj;
			}
			obj = this.pool[this.currPoolSize - 1];
			this.currPoolSize--;
			return obj;
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
		return this.currPoolSize;
	}
}
