package creational.objectpool;

public abstract class ReusableCreator {
	public abstract Object create();
	// release (external) resources for this object (i.e., connections, files, etc)
	public abstract void release(Object obj);
}
