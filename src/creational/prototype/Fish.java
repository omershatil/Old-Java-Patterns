package creational.prototype;

public class Fish extends Animal {
	private int finSize;
	public Fish(String name)
	{
		super(name, "BlookBlook");
	}
	public void setFinSize(int finSize)
	{
		this.finSize = finSize;
	}
	public int getFinSize() {
		return finSize;
	}
}
