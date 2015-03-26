package structural.cachemanagement;

import java.lang.ref.*;

public class CleanupQueue {
	private ReferenceQueue refQ = new ReferenceQueue();
	private boolean cleaning = false;
	public WeakReference createSoftReference(Object obj, CleanUpIF cleanup)
	{
		return new WeakReference<Object>(obj, this.refQ);
	}
	public void cleanup()
	{
		synchronized (this) {
			if (cleaning) {
				return;
			}
			cleaning = true;
		}
		WeakReference pr = null;
		while ((pr = (WeakReference)refQ.poll()) != null) {
			// call the cleanup() function
			// NOTE: hasn't been tested. Need to force VM to release memory. How?
			// tried to make SomeObject waste memory, but that didn't work...
			CleanUpIF r = (CleanUpIF)pr.get();
			r.cleanUp();
		}
		cleaning = false;
	}
}
