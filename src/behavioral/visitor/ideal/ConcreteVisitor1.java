package behavioral.visitor.ideal;

/** all comments relate to the Visitor. For Composite comments see the Composite pattern
 * 
 * @author oshatil
 *
 */
public class ConcreteVisitor1 implements VisitorIF {
	public void visit(AbstractComponentIdeal comp) {
		System.out.println("ConcreteVisitor1 visiting Component " + comp.getClass().getName() + 
				". Doing calculation...");
		System.out.println("...font is :" + comp.getFont());
	}
}
