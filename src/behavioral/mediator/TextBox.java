package behavioral.mediator;

import java.util.*;

public class TextBox extends Widget {
	private List<TextBoxListenerIF>listeners = new ArrayList<TextBoxListenerIF>();
	
	public TextBox(String name)
	{
		super(name);
	}
	/**
	 * Called by client (GUI layer)
	 * @param text
	 */
	public void enterText(String text)
	{
		// call the Mediator to tell it to act on the event
		System.out.print("Text entered in text box \"" + this.getName() + "\": " + text + "\n");
		Iterator<TextBoxListenerIF> iter = this.listeners.iterator();
		while (iter.hasNext()) {
			TextBoxListenerIF listener = iter.next();
			listener.textEntered();
		}
	}
	public void enable()
	{
		// called by the Mediator
		System.out.print("Text Box is enabled: " + this.getName() + "\n");
	}
	public void addListener(TextBoxListenerIF tbl)
	{
		this.listeners.add(tbl);
	}
}
