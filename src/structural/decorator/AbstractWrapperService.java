package structural.decorator;

/**
 * The abstract class does nothing but delegate to the wrapee
 * @author מרים
 *
 */
public abstract class AbstractWrapperService implements OriginalServiceIF{
	private OriginalServiceIF wrapee;

	public AbstractWrapperService(OriginalServiceIF wrapee)
	{
		this.wrapee = wrapee;
	}
	public void doThis()
	{
		// delegate
		this.wrapee.doThis();
	}
	public void doThat()
	{
		// delegate
		this.wrapee.doThat();
	}
}
