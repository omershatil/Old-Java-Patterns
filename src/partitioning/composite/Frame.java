package partitioning.composite;

public class Frame extends AbstractHtmlpageComposite {
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
		System.out.print("Frame Composite\n");
	}
}
