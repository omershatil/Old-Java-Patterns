package concurrency.lockobject.differentclasses;

public class NodeType1 extends  AbstractNode {
	
	public NodeType1(String name) {
		super(name);
	}
	public void doSomethingOfType1() {
		synchronized (this.getLock()) {
			System.out.println(this.getName() + " of type NodeType1 is doing something");
			try {
				Thread.sleep(3000);
			}
			catch (InterruptedException ie) {
				
			}
			System.out.println(this.getName() + " of type NodeType1 is DONE doing something");
		}
	}
}
