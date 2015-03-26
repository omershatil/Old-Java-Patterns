package behavioral.snapshot;

import java.io.*;

public class Serializer {
	private GameModel gameModel;
	private String fileName;
	
	public Serializer(GameModel gameModel, String fileName)
	{
		this.gameModel = gameModel;
		this.fileName = fileName;
	}
	public void saveGame()
	{
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(this.fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(this.gameModel);
		}
		catch (FileNotFoundException fnfe) {
			System.out.print("File Not Found: " + fnfe.getMessage());
		}
		catch (IOException ioe) {
			System.out.print("IOException: " + ioe.getMessage());
		}
		finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (fos != null) {
					fos.close();
				}
			}
			catch (IOException ioe) {
				// log and ignore
				System.out.print("IOException: " + ioe.getMessage());
			}
		}
	}
}
