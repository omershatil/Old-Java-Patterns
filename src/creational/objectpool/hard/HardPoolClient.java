package creational.objectpool.hard;

import creational.objectpool.*;

public class HardPoolClient {
	public void createSomeObjects()
	{
		HardObjectPool pool = new HardObjectPool(Scarce.class, Scarce.getCreator(), 4, 3);
		Scarce obj1 = (Scarce)pool.acquireReusable();
		Scarce obj2 = (Scarce)pool.acquireReusable();
		try {
			pool.releaseReusable(obj2);
		}
		catch (Exception e) {
			System.out.print("Failed to release object to pool. " + e.getMessage() + "\n");
		}
		obj2 = (Scarce)pool.acquireReusable();
		Scarce obj3 = (Scarce)pool.acquireReusable();
		// obj4 should be null
		Scarce obj4 = (Scarce)pool.acquireReusable();
		System.out.print("obj1: " + obj1 + "\n");
		System.out.print("obj2: " + obj2 + "\n");
		System.out.print("obj3: " + obj3 + "\n");
		System.out.print("obj4: " + obj4 + "\n");
		// spawn another thread that will wait till we release object to the pool
		MyThread myThread = new MyThread(pool);
		Thread thread = new Thread(myThread, "myThread");
		thread.start();
		// release an object after sleeping for a while
		try {
			// sleep so that the other thread grabs available object
			Thread.sleep(500);
		}
		catch (InterruptedException ie) {
			
		}
		try {
			pool.releaseReusable(obj1);
		}
		catch (Exception e) {
			System.out.print("Failed to release object to pool. " + e.getMessage());
		}
		try {
			// sleep so that the other thread grabs available object
			Thread.sleep(500);
		}
		catch (InterruptedException ie) {
			
		}
		System.out.print("maxObjectCount: " + pool.getMaxObjectCount() + "\n");
		System.out.print("currObjectCount: " + pool.getCurrObjectCount() + "\n");
		System.out.print("Pool size: " + pool.getPoolSize() + "\n");
		try {
			pool.releaseReusable(obj2);
		}
		catch (Exception e) {
			System.out.print("Failed to release object to pool. " + e.getMessage());
		}
		System.out.print("After releaing obj2:\n");
		System.out.print("currObjectCount: " + pool.getCurrObjectCount() + "\n");
		System.out.print("Pool size: " + pool.getPoolSize() + "\n");
	}
}
