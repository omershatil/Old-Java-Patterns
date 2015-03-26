package concurrency.lockobject.sameclass;

public class SomeAbstractClass {
	private String name;
	static private Object lock = new Object();
	
	public SomeAbstractClass(String name) {
		this.name = name;
	}
	static public Object getLock() {
		return lock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
