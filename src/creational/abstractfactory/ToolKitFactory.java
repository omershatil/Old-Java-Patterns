package creational.abstractfactory;

/**
 * Singleton Factory Method which creates widget factories per OS.
 * @author מרים
 *
 */public class ToolKitFactory {
	static private ToolKitFactory factory = new ToolKitFactory();
	
	private ToolKitFactory()
	{
	}
	public static ToolKitFactory getInstance()
	{
		return factory;
	}
	public FactoryIF getFactory(String type) throws Exception
	{
		if (type.equalsIgnoreCase(AbstractFactoryConstants.ToolkitType.WINDOWS.toString())) {
			return new WindowsWidgetFactory();
		}
		else if (type.equalsIgnoreCase(AbstractFactoryConstants.ToolkitType.LINUX.toString())) {
			return new LinuxWidgetFactory();
		}
		else {
			throw new Exception("Type: " + type + " undefined");
		}
	}
}
