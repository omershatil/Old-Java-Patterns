package fundemental.delegation;

/**
 * Delegetee - retuns its food order from the delegator (CrewMember)
 * @author oshatil
 *
 */
public class Passenger {
	private String foodOrder;
	
	public Passenger(String foodOrder)
	{
		this.foodOrder = foodOrder;
	}
	// actions
	public String giveFoodOrder()
	{
		return foodOrder;
	}
	// properties getters/setters
	public String getFoodOrder() {
		return foodOrder;
	}
	public void setFoodOrder(String foodOrder) {
		this.foodOrder = foodOrder;
	}
}
