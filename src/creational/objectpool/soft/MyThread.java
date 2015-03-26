package creational.objectpool.soft;

import creational.objectpool.*;

public class MyThread implements Runnable {
	private SoftObjectPool pool;
	
	public MyThread(SoftObjectPool pool)
	{
		this.pool = pool;
	}
	public void run()
	{
		Scarce obj1 = (Scarce)pool.waitForReusable();
	}
}
