package structural.iterator;

import java.util.*;

/**
 * The implementation simply wraps a Collection and uses it to demo the Iterator
 * pattern. The iterator itself is an inner private class.
 * @author מרים
 *
 */
public class MyCollection {
	private Collection collection;
	
	public MyCollection()
	{
		this.collection = new ArrayList();
	}
	public IteratorIF Iterator()
	{
		return new MyIterator();
	}
	public void add(Object o)
	{
		this.collection.add(o);
	}
	private class MyIterator implements IteratorIF {
		private Iterator iter;
		
		private MyIterator()
		{	
			this.iter = collection.iterator();
		}
		public boolean hasNext()
		{
			return this.iter.hasNext();
		}
		public Object next()
		{
			return this.iter.next();
		}
	}
}
