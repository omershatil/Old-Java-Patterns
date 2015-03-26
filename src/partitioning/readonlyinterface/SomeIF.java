package partitioning.readonlyinterface;

/**
 * Read-only interface does not include any mutating methods. The "set"
 * methods are implemented in the deriving classes. Clients access the objects
 * via this read-only interface
 * @author מרים
 *
 */
public interface SomeIF {
	public String getSomeStringValue();
}
