package creational.prototype;

public class Dog extends Animal {
	private int numTicks;
	
	public Dog(String name)
	{
		super(name, "Hav");
	}
	
	public int getNumTicks() {
		return numTicks;
	}

	public void setNumTicks(int numTicks) {
		this.numTicks = numTicks;
	}

}
