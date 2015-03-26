package behavioral.snapshot;

import java.io.*;

public class GameModel implements Serializable {
	static private GameModel instance = new GameModel(); 
	private MilestoneMementoManager mementoManager;
	private int numKilledAliens = 0;
	// the following is just to demonstrate the use of "transient" variables during serialization
	private transient RandomAccessFile raf;
	private byte []buf = new byte[1024];
	
	private GameModel()
	{
		this.mementoManager = new MilestoneMementoManager(this);
		try {
			this.raf = new RandomAccessFile("Snapshot.txt", "r");
			// TODO: When should the file be closed?
			this.raf.read(buf, 0, 5);
			String temp = new String(buf);
			temp = temp.substring(0, 5);
			System.out.print("Snapshot.txt read: " + temp + "\n");
		}
		catch (FileNotFoundException fnfe) {
			System.out.print("File Not Found: " + fnfe.getMessage() + "\n");
		}
		catch (IOException ioe) {
			System.out.print("IOException: " + ioe.getMessage() + "\n");
		}
	}
	static public GameModel getGameModel()
	{
		return instance;
	}
	/**
	 * This function is to demonstrate how we override the ObjectOutputStream writeObject
	 * method when using "transient" members. Note that it is private
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException
	{
		// call the default serialization
		stream.defaultWriteObject();
		// now do special handling for transient variable: save the file pointer
		// so that when we deserialize this object we can open the file at the exact location
		stream.writeLong(raf.getFilePointer());
	}
	/**
	 * This function is to demonstrate how we override the ObjectOutputStream writeObject
	 * method when using "transient" members. Note that it is private
	 * @param stream
	 * @throws IOException
	 */
	private void readObject(ObjectInputStream stream) throws IOException
	{
		try {
			// call the default deserialization
			stream.defaultReadObject();
		}
		catch (ClassNotFoundException cnfe) {
			System.out.print("ClassNotFoundException: " + cnfe.getMessage() + "\n");
		}
		if (this.raf != null) {
			try {
				this.raf.close();
			}
			catch (IOException ioe) {
				System.out.print("IOException: " + ioe.getMessage() + "\n");
			}
		}
		try {
			this.raf = new RandomAccessFile("Snapshot.txt", "r");
			// seek to the value that was saved in the serialized file
			this.raf.seek(stream.readLong());
			this.raf.read(buf, 5, 5);
			String temp = new String(buf);
			temp = temp.substring(0, 10);
			System.out.print("Snapshot.txt read: " + temp + "\n");
		}
		catch (FileNotFoundException fnfe) {
			System.out.print("File Not Found: " + fnfe.getMessage() + "\n");
		}
		catch (IOException ioe) {
			System.out.print("IOException: " + ioe.getMessage() + "\n");
		}
		finally {
			if (this.raf != null) {
				try {
					this.raf.close();
				}
				catch (IOException ioe) {
					System.out.print("IOException: " + ioe.getMessage() + "\n");
				}
			}
		}
	}
	/**
	 * This function will be called by ObjectInputStream when deserializing the
	 * object, so that you can return whatever object you want, rather than the
	 * object created by the deserialization process.
	 * In this case, since there is a single static instance of GameModel,
	 * we want to return that static instance. Before 
	 * returning, though, we set all of the member variables to the deserialized 
	 * values (only one member to set: mementoManager.
	 * @return
	 */
	public Object readResolve() 
	{
		// get the instance that we want to return
		GameModel theModel = getGameModel();
		// now set the instance values to the deserialized values
		theModel.mementoManager = mementoManager;
		theModel.numKilledAliens = numKilledAliens;
		// return the instance
		return theModel;
	}
	/**
	 * Called to save a game instance into memory to be used at a later time
	 * if the user chooses to do so.
	 * @param description
	 */
	public MilestoneMementoIF createMemento(String description)
	{
		// create the memento
		MilestoneMemento memento = new MilestoneMemento(description);
		// set all the information for the GameModel to be saved
		memento.mementoManager = this.mementoManager;
		memento.numKilledAliens = this.numKilledAliens;
		return memento;
	}
	/**
	 * Restore a memento. set all the variables on the GameModel instance
	 * @param memento
	 */
	public void restoreMemento(MilestoneMementoIF memento)
	{
		MilestoneMemento m = (MilestoneMemento)memento;
		this.mementoManager = m.mementoManager;
		this.numKilledAliens = m.numKilledAliens;
	}
	// Here are some of the game related methods
	public void killedAnAlien()
	{
		this.numKilledAliens = this.numKilledAliens + 1;
	}
	/**
	 * This class preserves all the information from GameModel that needs to be
	 * preserved in order to restore the game at some poing, (while the game is on!).
	 * The information is gone as soon as the player quits.
	 * @author oshatil
	 *
	 */
	private class MilestoneMemento implements MilestoneMementoIF {
		// user description of this memento instance
		private String description;
		// following is all the information needed to save and restore a GameModel instance
		// The information is accessed directly by the create/restoreMemento functions of GameModel.
		// No need for accessor methods (get/set)
		MilestoneMementoManager mementoManager;
		int numKilledAliens;
		
		MilestoneMemento(String description)
		{
			this.description = description;
		}

		public String getDescription() {
			return description;
		}
	}
	public MilestoneMementoManager getMilestoneMementoManager() {
		return mementoManager;
	}
	public int getNumKilledAliens() {
		return numKilledAliens;
	}
}
