package creational.builder;

/**
 * The sleazy contructor doesn't like to work too hard. He gets the 
 * instructions from the new home owner and asks a builder to build the house.
 * @author oshatil
 *
 */
public class SleazyContractor {
	public void init()
	{
		// get specs for an igloo and a tepee and ask builder to do the job.
		// return results to owners and see what they say...
		NewIglooOwner iglooOwner = new NewIglooOwner();
		HomeSpecs specs = iglooOwner.getNewHomeSpecs();
		HomeBuilder iglooBuilder = HomeBuilder.getBuilder(specs.getHomeType());
		iglooBuilder.buildCeiling(specs.getCeilingType());
		iglooBuilder.buildDoors(specs.getNumDoors());
		iglooBuilder.buildWalls(specs.getNumWalls());
		iglooBuilder.buildWindows(specs.getNumWindows());
		HomeIF home = iglooBuilder.getNewHome();
		System.out.print("Home type: " + home.getClass() + "\n");
		System.out.print("Number of walls: " + home.getNumWalls() + "\n");		
		System.out.print("Number of doors: " + home.getNumDoors() + "\n");		
		System.out.print("Number of windows: " + home.getNumWindows() + "\n");		
		System.out.print("Ceiling type: " + home.getCeilingType() + "\n");
		if (iglooOwner.receiveNewHome(home) == false) {
			System.out.print("Igloo owner refused to recieve the new home\n");
		}
		else {
			System.out.print("Igloo owner accepted the new home\n");
		}
		
		NewTepeeOwner tepeeOwner = new NewTepeeOwner();
		specs = tepeeOwner.getNewHomeSpecs();
		HomeBuilder tepeeBuilder = HomeBuilder.getBuilder(specs.getHomeType());
		tepeeBuilder.buildCeiling(specs.getCeilingType());
		tepeeBuilder.buildDoors(specs.getNumDoors());
		tepeeBuilder.buildWalls(specs.getNumWalls());
		tepeeBuilder.buildWindows(specs.getNumWindows());
		home = tepeeBuilder.getNewHome();
		System.out.print("Home type: " + home.getClass() + "\n");
		System.out.print("Number of walls: " + home.getNumWalls() + "\n");		
		System.out.print("Number of doors: " + home.getNumDoors() + "\n");		
		System.out.print("Number of windows: " + home.getNumWindows() + "\n");		
		System.out.print("Ceiling type: " + home.getCeilingType() + "\n");
		if (tepeeOwner.receiveNewHome(home) == false) {
			System.out.print("Tepee owner refused to recieve the new home\n");
		}
		else {
			System.out.print("Tepee owner accepted the new home\n");
		}
	}
}
