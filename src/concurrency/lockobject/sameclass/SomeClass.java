package concurrency.lockobject.sameclass;

public class SomeClass extends SomeAbstractClass {
	private int mutable = 0;

	public SomeClass(String name) {
		super(name);
	}
	public void increment() 
	{
		synchronized (this.getLock()) {
			System.out.println(this.getName() + " incrementing takes 3 seconds");
			try {
				Thread.sleep(3000);
			}
			catch (InterruptedException ie) {
				
			}
			System.out.println(this.getName() + " done incrementing");
		}
	}
}
