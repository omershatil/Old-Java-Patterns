package structural.decorator;

/**
 * Concrete wrapper classes only implement new functionality!
 * @author מרים
 *
 */
public class WrapperServiceA extends AbstractWrapperService {
	public WrapperServiceA(OriginalServiceIF wrapee)
	{
		super(wrapee);
	}
	public void doSomethingNew1()
	{
		System.out.print("WrapperServiceA doing new extended functionality\n");
	}
	public void doSomethingNew2()
	{
		System.out.print("WrapperServiceA doing additional new extended functionality\n");
	}
}
