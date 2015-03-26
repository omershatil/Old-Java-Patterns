package behavioral.state;

public class UI {
	private int i = 0;
	
	public void uiActivityStateOne()
	{
		System.out.print("Doing some UI initialization for StateOne\n");
	}
	public void uiActivityStateTwo()
	{
		System.out.print("Doing some UI activity for StateTwo\n");
	}
	public void uiActivityStateThree()
	{
		System.out.print("Doing some UI activity for StateThree\n");
	}
	public void uiActivityStateFour()
	{
		System.out.print("Doing some UI activity for StateFour\n");
	}
	/**
	 * need to generate some different condition so that code flows from one state to the next
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
