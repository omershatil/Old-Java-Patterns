package behavioral.visitor.ideal;

/** all comments relate to the Visitor. For Composite comments see the Composite pattern
 * 
 * @author oshatil
 *
 */
public class ConcreteVisitor2 implements VisitorIF {
	public void visit(AbstractComponentIdeal comp) {
		System.out.println("ConcreteVisitor2 visiting Component " + comp.getClass().getName() + 
				". Doing calculation...");
		System.out.println("...pixel width is :" + comp.getComponentPixelWidth());
	}
}
