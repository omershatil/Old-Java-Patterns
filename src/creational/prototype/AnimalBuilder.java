package creational.prototype;

import java.io.*;

/**
 * This is the PrototypeBuilder. For our purposes it will get enimals from a stream
 * prepared by StreamGenerator and register them with the store.
 * @author oshatil
 *
 */
public class AnimalBuilder {
	public void createAndRegisterAnimals(AnimalStore store)
	{
		StreamGenerator generator = new StreamGenerator();
		generator.saveFile();
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("myobjects.ser");
			ois = new ObjectInputStream(fis);
			Animal animal = null;
			try {
				while ((animal = (Animal)ois.readObject()) != null) {
					store.registerAnimal(animal);
				}	
			}
			catch (ClassNotFoundException cnfe) {
				System.out.print(cnfe);
			}
		}
		catch (IOException ex) {
			System.out.print(ex);
		}
		finally {
			try {
				fis.close();
				ois.close();
			}
			catch (IOException ioe) {
				
			}
		}
	}
}
