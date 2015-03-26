package behavioral.state;

public class Context {
	private int i = 0;
	private static Context instance = new Context();
	private AbstractState state;
	
	private Context()
	{
	}
	public static Context getContext()
	{
		return instance;
	}
	public void start()
	{
		state = AbstractState.start(this);
		state = state.processEvent(AbstractState.EVENT_X);
		state = state.processEvent(AbstractState.EVENT_Y);
		state = state.processEvent(AbstractState.EVENT_Z);
		state = state.processEvent(AbstractState.EVENT_X);
		state = state.processEvent(AbstractState.EVENT_Y);
		state = state.processEvent(AbstractState.EVENT_Z);
	}
	public void doWorkForStateOne()
	{
		System.out.print("Context doing work for State One\n");
	}
	public void doWorkForStateTwo()
	{
		System.out.print("Context doing work for State Two\n");
		state = state.processEvent(AbstractState.EVENT_Z);
	}
	public void doWorkForStateThree()
	{
		System.out.print("Context doing work for State Three\n");
		state = state.processEvent(AbstractState.EVENT_Y);
	}
	public void doWorkForStateFour()
	{
		System.out.print("Context doing work for State Four\n");
		state = state.processEvent(AbstractState.EVENT_X);
	}
	/**
	 * need to generate some different condition so that code flows from one state to the next.
	 * This may not be part of every State pattern implementation.
	 * @return
	 */
	public int checkCondition()
	{
		if (i == 0) {
			return i++;
		}
		else {
			return i--;
		}
	}
}
