package partitioning.composite;

import java.util.*;

/**
 * a composite that contains Character Component objects and other composites
 * like itself.
 * @author מרים
 *
 */
public class LineOfText extends AbstractHtmlpageComposite {
	public int getFont()
	{
		return 2;
	}
	public CompositeConstants.ImageType getImageType()
	{
		return CompositeConstants.ImageType.none;
	}
	public int getComponentPixelWidth() {
		// determine dimension by font size and character
		return 23;
	}
	public int getComponentPixelHeight() {
		// determine dimension by font size and character
		return 23;
	}
	public void print()
	{
		System.out.print("LineOfText Composite:\n");
		Iterator <ComponentIF>iter = this.getChildren().iterator();
		while (iter.hasNext()) {
			iter.next().print();
		}
	}
}
