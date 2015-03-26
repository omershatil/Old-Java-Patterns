package partitioning.composite;

/**
 * A Component (not a composite)
 * @author מרים
 *
 */
public class Image extends AbstractHtmlpageComponent {
	private int pixelWidth;
	private int pixelHeight;
	private CompositeConstants.ImageType imageType;
	
	public Image(int pixelWidth, CompositeConstants.ImageType imageType)
	{
		this.pixelWidth = pixelWidth;
		this.imageType = imageType;
	}
	public int getFont()
	{
		return -1;
	}
	public int getComponentPixelHeight() {
		return pixelHeight;
	}
	public int getComponentPixelWidth() {
		return pixelWidth;
	}
	public CompositeConstants.ImageType getImageType() {
		return imageType;
	}
	public void print()
	{
		System.out.print("	Image component. Pixel Width: " + this.pixelWidth +
				". Pixel Height: " + this.pixelHeight + ". Image Type: " +
				this.imageType + "\n");
	}
}
