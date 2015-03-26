package behavioral.mediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PushButton extends Widget {
	private List<PushButtonListenerIF>listeners = new ArrayList<PushButtonListenerIF>();

	public PushButton(String name)
	{
		super(name);
	}
	public void enable()
	{
		// called by the Mediator
		System.out.print("PushButton is enabled: " + this.getName() + "\n");
	}
	public void click()
	{
		// call the Mediator to inform it that the widget was clicked
		System.out.print("PushButton is clicked: " + this.getName() + "\n");
		Iterator<PushButtonListenerIF> iter = this.listeners.iterator();
		while (iter.hasNext()) {
			PushButtonListenerIF listener = iter.next();
			listener.clicked();
		}
	}
	public void addListener(PushButtonListenerIF listener)
	{
		this.listeners.add(listener);
	}
}
