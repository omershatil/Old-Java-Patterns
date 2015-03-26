package creational.objectpool.hard;

import creational.objectpool.*;

public class MyThread implements Runnable {
	private HardObjectPool pool;
	
	public MyThread(HardObjectPool pool)
	{
		this.pool = pool;
	}
	public void run()
	{
		Scarce obj1 = (Scarce)pool.waitForReusable();
	}
}
