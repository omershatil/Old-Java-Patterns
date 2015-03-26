package structural.decorator;

/**
 * Demonstrate that you can use a single wrapper to wrap any of the original
 * services! This multiplicity decreases the number of classes that would
 * have been required if we implemented the same functionality using inheritance
 * (however, more objects will get created this using delegation)
 * @author מרים
 *
 */
public class ClientOfDecorator {
	public void useWrapperAServiceA()
	{
		WrapperServiceA wrapperA = new WrapperServiceA(new OriginalServiceA());
		wrapperA.doThis();
		wrapperA.doThat();
		wrapperA.doSomethingNew1();
		wrapperA.doSomethingNew2();
	}
	public void useWrapperBServiceB()
	{
		WrapperServiceB wrapperB = new WrapperServiceB(new OriginalServiceB());
		wrapperB.doThis();
		wrapperB.doThat();
		wrapperB.doSomethingNew1();
		wrapperB.doSomethingNew2();
	}
	public void useWrapperAServiceB()
	{
		WrapperServiceA wrapperA = new WrapperServiceA(new OriginalServiceB());
		wrapperA.doThis();
		wrapperA.doThat();
		wrapperA.doSomethingNew1();
		wrapperA.doSomethingNew2();
	}
	public void useWrapperBServiceA()
	{
		WrapperServiceB wrapperB = new WrapperServiceB(new OriginalServiceA());
		wrapperB.doThis();
		wrapperB.doThat();
		wrapperB.doSomethingNew1();
		wrapperB.doSomethingNew2();
	}
}
