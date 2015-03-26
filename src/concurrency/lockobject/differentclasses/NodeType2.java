package concurrency.lockobject.differentclasses;

public class NodeType2 extends  AbstractNode {
	
	public NodeType2(String name) {
		super(name);
	}
	public void doSomethingOfType2() {
		synchronized (this.getLock()) {
			System.out.println(this.getName() + " of type NodeType2 is doing something");
			try {
				Thread.sleep(3000);
			}
			catch (InterruptedException ie) {
				
			}
			System.out.println(this.getName() + " of type NodeType2 is DONE doing something");
		}
	}
}
