package creational.prototype;

public class Cat extends Animal {
	private int numFlees;

	public Cat(String name)
	{
		super(name, "Mewew");
	}

	public int getNumFlees() {
		return numFlees;
	}

	public void setNumFlees(int numFlees) {
		this.numFlees = numFlees;
	}
}
