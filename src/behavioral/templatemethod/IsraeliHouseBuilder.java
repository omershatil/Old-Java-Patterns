package behavioral.templatemethod;

public class IsraeliHouseBuilder extends HouseBuilder {
	public IsraeliHouseBuilder() {
		super("Israeli");
	}
	protected boolean buildRoof() {
		System.out.println("Israeli builder Building thatched roof");
		return true;
	}
	protected boolean buildWindows() {
		System.out.println("Israeli builder installing square windows");
		return true;
	}
}
