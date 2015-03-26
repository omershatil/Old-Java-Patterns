package behavioral.snapshot;

import java.io.*;

public class Deserializer {
	private String fileName;
	
	public Deserializer(String fileName)
	{
		this.fileName = fileName;
	}
	public void restoreGame()
	{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream(this.fileName);
			ois = new ObjectInputStream(fis);
			// IMPORTANT: we don't use the object that is read!!! readResolve takes care of
			// restoring the Singleton GameModel to the values we need from the serealization
			// information
			ois.readObject();
		}
		catch (ClassNotFoundException fnfe) {
			System.out.print("Class Not Found: " + fnfe.getMessage());
		}
		catch (FileNotFoundException fnfe) {
			System.out.print("File Not Found: " + fnfe.getMessage());
		}
		catch (IOException ioe) {
			System.out.print("IOException: " + ioe.getMessage());
		}
		finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (fis != null) {
					fis.close();
				}
			}
			catch (IOException ioe) {
				// log and ignore
				System.out.print("IOException: " + ioe.getMessage());
			}
		}
	}
}
