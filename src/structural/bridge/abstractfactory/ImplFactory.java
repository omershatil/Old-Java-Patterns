package structural.bridge.abstractfactory;

/**
 * Singleton Factory Method which creates Impl factories per vehicle.
 * @author מרים
 *
 */
public class ImplFactory {
	static private ImplFactory factory = new ImplFactory();
	
	private ImplFactory()
	{
	}
	public static ImplFactory getInstance()
	{
		return factory;
	}
	public VehicleFactoryIF getFactory(String type) throws Exception
	{
		if (type.equalsIgnoreCase(AbstractVehicleFactoryConstants.ImplType.BMW.toString())) {
			return new BmwImplFactory();
		}
		else if (type.equalsIgnoreCase(AbstractVehicleFactoryConstants.ImplType.GM.toString())) {
			return new MGImplFactory();
		}
		else {
			throw new Exception("Type: " + type + " undefined");
		}
	}
}
