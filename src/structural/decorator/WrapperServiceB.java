package structural.decorator;

/**
 * Concrete wrapper classes only implement new functionality!
 * @author מרים
 *
 */
public class WrapperServiceB extends AbstractWrapperService {
	public WrapperServiceB(OriginalServiceIF wrapee)
	{
		super(wrapee);
	}
	public void doSomethingNew1()
	{
		System.out.print("WrapperServiceB doing new extended functionality\n");
	}
	public void doSomethingNew2()
	{
		System.out.print("WrapperServiceB doing additional new extended functionality\n");
	}
}