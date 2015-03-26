package behavioral.templatemethod;

public class AmericanHouseBuilder extends HouseBuilder {
	public AmericanHouseBuilder() {
		super("American");
	}
	protected boolean buildRoof() {
		System.out.println("American builder Building flat roof");
		return true;
	}
	protected boolean buildWindows() {
		System.out.println("American builder installing round windows");
		return true;
	}
}
