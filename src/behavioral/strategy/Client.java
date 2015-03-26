package behavioral.strategy;

/**
 * By setting a different strategy on an instance of Client you dynamically change
 * its behavior. 
 * Another variation would be to have different Client objects contain different 
 * strategies assigned to them.
 * @author oshatil
 *
 */
public class Client {
	private StrategyIF strategy;
	
	public Client(StrategyIF strategy)
	{
		this.strategy = strategy;
	}
	public void doOperation()
	{
		this.strategy.operation();
	}
	public void setStrategy(StrategyIF strategy)
	{
		this.strategy = strategy;
	}
}
