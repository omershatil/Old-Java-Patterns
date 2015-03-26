package creational.prototype;

import java.io.*;

/**
 * Create a stream which contains the prototypes for the builder to read from
 * @author oshatil
 *
 */
public class StreamGenerator {
	public void saveFile()
	{
		// create the objctes
		Dog dog = new Dog("Bob");
		dog.setNumTicks(555);
		Cat cat = new Cat("Kitty");
		cat.setNumFlees(66);
		Fish fish = new Fish("Fishy");
		fish.setFinSize(10);
		// serialize the objects
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream("myobjects.ser"); 
			out = new ObjectOutputStream(fos);
			out.writeObject(dog);
			out.writeObject(cat);
			out.writeObject(fish);
		}
		catch (IOException ex) {
			System.out.print(ex);
		}
		finally {
			try {
				out.close();
				fos.close();
			}
			catch (IOException ioe) {
				
			}
		}
	}
}
