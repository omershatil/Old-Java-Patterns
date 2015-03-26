package behavioral.mediator;

/**
 * This is a simplistic example of a dialog which contains 3 widgets. The dialog is 
 * responsible for creating the Colleagues and their Mediator. It acts as a container
 * for these objects.
 * When text is entered into TextBox1, PushButton1 and PushButton2 are enabled. When 
 * either PushButton1 or PushButton2 are clicked, TextBox2 is enabled.
 * The demo thus shows the use of private named Adapters to enable the same sources
 * (in this case, both push buttons) to use the same Adapter for similar functionality.
 * The demo also shows how to use private annonymous adapter classes to enable different
 * functionality from 2 different sources (of the same class - the two text boxes).
 * @author oshatil
 *
 */
public class DialogBox {
	private DialogBoxMediator mediator = new DialogBoxMediator();
	private TextBox textBox1 = new TextBox("Text Box 1");
	private TextBox textBox2 = new TextBox("Text Box 2");
	private PushButton pushButton1 = new PushButton("Push Button 1");
	private PushButton pushButton2 = new PushButton("Push Button 2");
	private YesNoBox ynBox = new YesNoBox();
	
	public DialogBox()
	{
		this.mediator.registerTextBox1(textBox1);
		this.mediator.registerTextBox2(textBox2);
		this.mediator.registerPushButton(pushButton1);
		this.mediator.registerPushButton(pushButton2);
	}
	protected void textEnteredInTextBox1()
	{
		// enable both pushButton
		this.pushButton1.enable();
		this.pushButton2.enable();
	}
	protected void textEnteredInTextBox2()
	{
		// alert user
		this.ynBox.alertUser();
	}
	protected void pushButtonClicked()
	{
		// no matter which button was clicked, enable text box 2
		textBox2.enable();
	}
	/**
	 * The Mediator is a private inner class of the dialog. Only the dialog can use it.
	 * @author oshatil
	 *
	 */
	private class DialogBoxMediator 
	{
		private PushButtonAdapter pushButtonAdapter = new PushButtonAdapter();

		public void registerTextBox1(TextBox textBox1)
		{
			TextBoxListenerIF listener = new TextBoxListenerIF()  {
				public void textEntered()
				{
					// call dialog box
					textEnteredInTextBox1();
				}
			};
			textBox1.addListener(listener);
		}
		public void registerTextBox2(TextBox textBox2)
		{
			TextBoxListenerIF listener = new TextBoxListenerIF()  {
				public void textEntered()
				{
					// call dialog box
					textEnteredInTextBox2();
				}
			};
			textBox2.addListener(listener);
		}
		public void registerPushButton(PushButton pb)
		{
			pb.addListener(this.pushButtonAdapter);
		}
	}
	/**
	 * a named private adapter. used by multiple event sources (in this case it is
	 * used by push buttons 1 and 2
	 * @author oshatil
	 *
	 */
	private class PushButtonAdapter implements PushButtonListenerIF {
		public void clicked()
		{
			pushButtonClicked();
		}
	}
	public PushButton getPushButton1() {
		return pushButton1;
	}
	public PushButton getPushButton2() {
		return pushButton2;
	}
	public TextBox getTextBox1() {
		return textBox1;
	}
	public TextBox getTextBox2() {
		return textBox2;
	}
}
