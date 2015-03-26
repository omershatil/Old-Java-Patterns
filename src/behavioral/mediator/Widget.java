package behavioral.mediator;

public abstract class Widget {
	private String name;

	public Widget(String name) 
	{
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
