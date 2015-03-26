package behavioral.visitor.nonideal;

import partitioning.composite.AbstractHtmlpageComposite;
import partitioning.composite.ComponentIF;
import partitioning.composite.Document;

/** all comments relate to the Visitor. For Composite comments see the Composite pattern
 *  This visitor uses the Composite example I wrote w/o needing that example to change.
 *  The Composite is not aware that a Visitor exists.
 * @author oshatil
 *
 */
public class ConcreteVisitor1 implements VisitorIF {
	private Document doc;
	
	public ConcreteVisitor1(Document doc) {
		this.doc = doc;
	}
	public void listFonts() {
		for (ComponentIF comp : this.doc.getComponents()) {
			System.out.println("Font of component " + comp.getClass().getName() + " is: " + comp.getFont());
		}
		for (AbstractHtmlpageComposite compos : this.doc.getComposites()) {
			System.out.println("Font of component " + compos.getClass().getName() + " is: " + compos.getFont());
		}
	}
}
