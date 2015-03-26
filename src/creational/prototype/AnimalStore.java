package creational.prototype;

import java.util.*;

/**
 * This is the client of the PrototypeBuilder (AnimalBuilder). It has a method which
 * is called by the builder to register animals. It calls animals to clone themselves.
 * @author oshatil
 *
 */
public class AnimalStore {
	// this is the "prototype manager"
	private HashMap <Class, Animal>animals;
	private AnimalBuilder animalBuilder;
	
	public AnimalStore()
	{
		// instantiate the builder
		this.animals = new HashMap <Class, Animal>();
		this.animalBuilder = new AnimalBuilder();
		this.animalBuilder.createAndRegisterAnimals(this);
	}
	public void registerAnimal(Animal animal)
	{
		animals.put(animal.getClass(), animal);
	}
	/**
	 * Returns a clone
	 * @param animalClass
	 * @return
	 */
	public Animal buyAnimal(Class animalClass)
	{
		Animal animal = this.animals.get(animalClass);
		return animal.clone();
	}
}
