package partitioning.filter.pull;

import java.io.*;

/**
 * This is the source. Data is created here.
 * @author oshatil
 *
 */
public class Source implements SourceIF {
	public byte [] getData()
	{
		System.out.print("The Source getting the data from file...\n");
		// save data to file
		FileInputStream fis = null;
		byte [] bytes = new byte[65000];
		try {
			fis = new FileInputStream("sinkdata.txt");
			fis.read(bytes);
		}
		catch (FileNotFoundException fnfe) {
			// TODO:
			System.out.print("Source failed getting data. " + fnfe.getMessage() + "\n");
		}
		catch (IOException ioe) {
			// TODO:
			System.out.print("Source failed getting data. " + ioe.getMessage() + "\n");
		}
		finally {
			if (fis != null) {
				try {
					fis.close();
				}
				catch (IOException ioe) {
					// TODO:
				}
			}
		}
		return bytes;
	}
}
