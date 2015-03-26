package fundemental.delegation;

import java.util.*;

/**
 * Delegatee and delegator - Person delegates to it to get all food orders.
 * It delegates to Passenger to get each passenger's food order. Note that a CrewMember
 * may be also a Passenger...
 * @author oshatil
 *
 */
public class CrewMember {
	
	public CrewMember()
	{
	}
	// actions
	/**
	 * Delegates the food order collection back to the passenger role!
	 */
	public String collectFoodOrders(List <Person>passengers)
	{
		String orders = "";
		Iterator <Person>iter = passengers.iterator();
		while (iter.hasNext()) {
			Person passenger = iter.next();
			orders = orders + passenger.giveFoodOrder() + ";";
		}
		return orders;
	}
}
