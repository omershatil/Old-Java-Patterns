package fundemental.proxy;

public class MutableCounter {
	private int count;
	
	public MutableCounter(int count)
	{
		this.count = count;
	}
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
