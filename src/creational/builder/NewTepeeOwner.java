package creational.builder;

/**
 * A new home owner has the instructions of what kind of home they want.
 * He then receives the new home from the sleazy home owner.
 * @author oshatil
 *
 */
public class NewTepeeOwner implements NewHomeOwnerIF {
	public HomeSpecs getNewHomeSpecs()
	{
		HomeSpecs specs = new HomeSpecs();
		specs.setHomeType(BuilderConstants.HomeType.TEPEE);
		specs.setCeilingType(BuilderConstants.CeilingType.TRIANGLE);
		specs.setNumDoors(0);
		specs.setNumWindows(0);
		return specs;
	}
	public boolean receiveNewHome(HomeIF home)
	{
		if (isGoodHome(home)) {
			// owner yes likes home
			return true;
		}
		else {
			// owner no likes home!
			return false;
		}
	}
	private boolean isGoodHome(HomeIF home)
	{
		return false;
	}
}
