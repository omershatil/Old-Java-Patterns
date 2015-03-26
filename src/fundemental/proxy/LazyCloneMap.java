package fundemental.proxy;

import java.util.*;
import java.lang.reflect.*;

/**
 * This Proxy pattern for map objects calls the super class' clone() method only when
 * the map changes by operations such as put(), remove() etc. It keeps a counter
 * and if such altering operation is called on a LazyCloneMap object it will clone
 * the underlying map, reduce the counter on the original map and set the counter
 * to 1 on the new clone. This way it postpones the cloning as much as it can.
 * @author oshatil
 *
 */
public class LazyCloneMap implements Map, Cloneable {
	private Map internalMap;
	private Method cloneMethod;
	private MutableCounter counter;
	private static Class[] cloneParams = new Class[0];
	
	public LazyCloneMap(Map mapObject) throws NoSuchMethodException, InvocationTargetException
	{
		this.cloneMethod = mapObject.getClass().getMethod("clone", cloneParams);
		try {
			this.internalMap = (Map)this.cloneMethod.invoke(mapObject, new Object[0]);
		}
		catch (IllegalAccessException iae) {
			//should never happen
		}
		this.counter = new MutableCounter(1);
	}
	/**
	 * Increment the counter and return a shallow clone object
	 */
	public LazyCloneMap clone()
	{
		LazyCloneMap theClone = null;
		try {
			theClone = (LazyCloneMap)super.clone();
		}
		catch (CloneNotSupportedException cnse) {
			// TODO:
		}
		this.counter.setCount(this.counter.getCount() + 1);
		return theClone;
	}
	/**
	 * Called whenever a method that modifies the underlying map is called.
	 * Copy the underlying map. Create a new LazyCloneMap object and set its 
	 * counter to 1.
	 *
	 */
	public void enforceClone()
	{
		if (counter.getCount() > 1) {
			try {
				this.internalMap = (Map)this.cloneMethod.invoke(this.internalMap, new Object[0]);
			}
			catch (IllegalAccessException iae) {
				//TODO
			}
			catch (InvocationTargetException ite) {
				//TODO
			}
			// this call effects the counter that is shared by all other cloned LazyCloneMap
			this.counter.setCount(counter.getCount() - 1);
			// this effects only the new cloned object
			this.counter = new MutableCounter(1); 
		}
	}
	// The following methods require us to do real cloning since they modify 
	// the map
	public void clear()
	{
		enforceClone();
		this.internalMap.clear();
	}
	public Object put(Object key, Object value)
	{
		enforceClone();
		return this.internalMap.put(key, value);
	}
	public void putAll(Map m)
	{
		enforceClone();
		this.internalMap.putAll(m);
	}
	public Object remove(Object o)
	{
		enforceClone();
		return this.internalMap.remove(o);
	}
	//
	public boolean isEmpty()
	{
		return this.internalMap.isEmpty();
	}
	public boolean containsKey(Object key)
	{
		return this.internalMap.containsKey(key);
	}
	public boolean containsValue(Object value)
	{
		return this.internalMap.containsValue(value);
	}
	public boolean equals(Object o)
	{
		return this.internalMap.equals(o);
	}
	public Object get(Object key)
	{
		return this.internalMap.get(key);
	}
	public int size()
	{
		return this.internalMap.size();
	}
	public Set keySet()
	{
		return this.internalMap.keySet();
	}
	public Set entrySet()
	{
		return this.internalMap.entrySet();
	}
	public Collection values()
	{
		return this.internalMap.values();
	}
	public String toString()
	{
		return this.internalMap.toString();
	}
	public int hashCode()
	{
		return this.internalMap.hashCode();
	}
}
