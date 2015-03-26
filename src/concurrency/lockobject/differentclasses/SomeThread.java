package concurrency.lockobject.differentclasses;

public class SomeThread implements Runnable {
	private NodeIF node;
	
	public SomeThread(NodeIF node) {
		this.node = node;
	}
	public void run() {
		if (this.node instanceof NodeType1) {
			((NodeType1)node).doSomethingOfType1();
		}
		else if (this.node instanceof NodeType2) {
			((NodeType2)node).doSomethingOfType2();
		} 
	}
}
