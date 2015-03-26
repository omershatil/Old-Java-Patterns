package creational.abstractfactory;

public class WindowsWidgetFactory implements FactoryIF {
	public ButtonIF createButton()
	{
		return new WindowsButton();
	}
	public CheckBoxIF createCheckBox()
	{
		return new WindowsCheckBox();
	}
}
