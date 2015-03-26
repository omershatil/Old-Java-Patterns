package behavioral.templatemethod;

public class ClientHouseBuilder {
	public void doIt() {
		IsraeliHouseBuilder israeliBuilder = new IsraeliHouseBuilder();
		israeliBuilder.buildMeAHouse();
		AmericanHouseBuilder americanBuilder = new AmericanHouseBuilder();
		americanBuilder.buildMeAHouse();
	}
}
