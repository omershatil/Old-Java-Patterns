package concurrency.lockobject.differentclasses;

public class AbstractNode implements NodeIF {
	private String name;
	private NodeIF parent;
	private Object lock = new Object();
	
	public AbstractNode(String name) {
		this.name = name;
	}
	public Object getLock() {
		if (this.parent != null) {
			System.out.println(this.name + " is NOT the root. it is asking its parent to return its lock");
			return this.parent.getLock();
		}
		else {
			System.out.println(this.name + " is the root!!! it is returning its lock");
			return this.lock;
		}
	}

	public void setParent(NodeIF parent) {
		this.parent = parent;
	}
	public NodeIF getParent() {
		return parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
