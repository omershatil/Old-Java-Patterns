package behavioral.visitor.ideal;

import java.util.*;

/** all comments relate to the Visitor. For Composite comments see the Composite pattern
 * 
 * @author oshatil
 *
 */
public class LineOfText extends AbstractCompositeIdeal {
	public int getFont()
	{
		return 2;
	}
	public String getImageType()
	{
		return "";
	}
	public int getComponentPixelWidth() {
		return 23;
	}
	public int getComponentPixelHeight() {
		return 23;
	}
	public void print()
	{
		System.out.print("LineOfText Composite:\n");
		Iterator <ComponentIdealIF>iter = this.getChildren().iterator();
		while (iter.hasNext()) {
			iter.next().print();
		}
	}
}
