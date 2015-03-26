package behavioral.visitor.nonideal;

import partitioning.composite.AbstractHtmlpageComposite;
import partitioning.composite.Document;

/** all comments relate to the Visitor. For Composite comments see the Composite pattern
 *  This visitor uses the Composite example I wrote w/o needing that example to change.
 *  The Composite is not aware that a Visitor exists.
 * @author oshatil
 *
 */
public class ConcreteVisitor2 implements VisitorIF {
	private Document doc;
	
	public ConcreteVisitor2(Document doc) {
		this.doc = doc;
	}
	public partitioning.composite.LineOfText getALine() {
		for (AbstractHtmlpageComposite compos : this.doc.getComposites()) {
			if (compos instanceof partitioning.composite.LineOfText) {
				return (partitioning.composite.LineOfText)compos;
			}
		}
		return null;
	}
}
