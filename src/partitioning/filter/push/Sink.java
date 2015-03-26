package partitioning.filter.push;

import java.io.*;

/**
 * This is the sink. Data ends up here.
 * @author oshatil
 *
 */
public class Sink implements SinkIF {
	public void putData(byte [] data)
	{
		System.out.print("The Sink has received the data and is saving it...\n");
		// save data to file
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("sinkdata.txt");
			fos.write(data);
		}
		catch (FileNotFoundException fnfe) {
			// TODO:
			System.out.print("Sink failed saving pushed data. " + fnfe.getMessage() + "\n");
		}
		catch (IOException ioe) {
			// TODO:
			System.out.print("Sink failed saving pushed data. " + ioe.getMessage() + "\n");
		}
		finally {
			if (fos != null) {
				try {
					fos.close();
				}
				catch (IOException ioe) {
					// TODO:
				}
			}
		}
	}
}
