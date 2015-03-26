package concurrency.lockobject.differentclasses;

public interface NodeIF {
	public Object getLock();
	public void setParent(NodeIF parent);
	public NodeIF getParent();
}
