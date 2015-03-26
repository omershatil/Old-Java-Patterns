package creational.objectpool;

/**
 * Need to ensure that only the creator can create Scarce instances. The way to 
 * do this is to have the creator be a private class of Scarce and implement a static
 * method to get the creator 
 * @author oshatil
 *
 */
public class Scarce {
	static private int count = 0;
	private String name;
	static private ScarceCreator creator;
	
	static public ScarceCreator getCreator()
	{
		if (creator == null) {
			creator = ScarceCreator.getInstance();
		}
		return creator;
	}
	private Scarce(String name)
	{
		this.name = name;
	}
	public String toString()
	{
		return name;
	}
	
	/**
	 * ScarceCreator is static, otherwise we'd have to create an instance of Scarce
	 * (in getCreator) in order to create an instance of ScarceCreator. We don't want
	 * to create this extra instance
	 * @author oshatil
	 *
	 */
	static private class ScarceCreator extends ReusableCreator {
		static private ScarceCreator instance;
		
		private ScarceCreator() {}
		
		/**
		 * Making ScarceCreator a singleton may be an overkill, but it ensures
		 * that nowhere else in Scarce an instance of the factory will instantiate
		 * another creator 
		 * @return
		 */
		static private ScarceCreator getInstance()
		{
			if (instance == null) {
				return new ScarceCreator();
			}
			return instance;
		}
		public Object create()
		{
			count = count + 1;
			return new Scarce(new Integer(count).toString());
		}
		public void release(Object obj)
		{
			// do something to release external resources
		}
	}
}
