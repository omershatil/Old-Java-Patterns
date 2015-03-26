package behavioral.templatemethod;

/**
 * Every house has to have walls, windows and roof, but doesn't have to have a
 * garage door. Allow each subclass to create it's own windows and roofs, but walls
 * are all made of wood in CA, so supply a concreate implementation. Also, the build()
 * method is concreate, since all subclasses will have to call it.
 * @author oshatil
 *
 */
abstract public class HouseBuilder implements HouseBuilderIF {
	private String houseType;
	public HouseBuilder(String houseType) {
		this.houseType = houseType;
	}
	public boolean buildMeAHouse() {
		buildWalls();
		buildRoof();
		buildWindows();
		return true;
	}
	protected boolean buildWalls() {
		System.out.println(this.houseType + " Building wall #1");
		System.out.println(this.houseType + " Building wall #2");
		System.out.println(this.houseType + " Building wall #3");
		System.out.println(this.houseType + " Building wall #4");
		return true;
	}
	abstract protected boolean buildRoof();
	abstract protected boolean buildWindows();
}
