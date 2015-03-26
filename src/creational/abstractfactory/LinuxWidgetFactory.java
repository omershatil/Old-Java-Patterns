package creational.abstractfactory;

public class LinuxWidgetFactory implements FactoryIF {
	public ButtonIF createButton()
	{
		return new LinuxButton();
	}
	public CheckBoxIF createCheckBox()
	{
		return new LinuxCheckBox();
	}
}
