package fundemental.delegation;

import java.util.*;

/**
 * This is somewhat complex delegator example b/c of circularity:
 * Person is both a delegator and a delgatee! 
 * Delegates the collection of food orders to CrewMember objects.
 * Crew member will delegate back to Person and Person will delegate to Passenger role!
 * @author oshatil
 *
 */
public class Person {
	private String name;
	private int id;
	private CrewMember crewMemberRole;
	private Passenger passengerRole;
	private TicketAgent agentRole;
	public Person(String name, int id)
	{
		this.name = name;
		this.id = id;
		this.crewMemberRole = null;
		this.agentRole = null;
		this.passengerRole = null;
	}
	// actions
	/**
	 * Delegate collection of orders to crew member role. pass the passenger list.
	 */
	public String takeFoodOrders(List <Person>passengers)
	{
		if (this.crewMemberRole != null) {
			return this.crewMemberRole.collectFoodOrders(passengers);
		}
		return null;
	}
	/**
	 * Delegate collection of orders to passenger role.
	 */
	public String giveFoodOrder()
	{
		if (this.passengerRole != null) {
			return this.passengerRole.giveFoodOrder();
		}
		return null;
	}
	// set/get properties
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TicketAgent getAgentRole() {
		return agentRole;
	}
	public void setAgentRole(TicketAgent agentRole) {
		this.agentRole = agentRole;
	}
	public CrewMember getCrewMemberRole() {
		return crewMemberRole;
	}
	public void setCrewMemberRole(CrewMember crewMemberRole) {
		this.crewMemberRole = crewMemberRole;
	}
	public Passenger getPassengerRole() {
		return passengerRole;
	}
	public void setPassengerRole(Passenger passengerRole) {
		this.passengerRole = passengerRole;
	}
}
