package creational.prototype;

import java.util.*;

/**
 * The Customer buys animals. It knows the class of animal that it needs, so 
 * it can call the animal store with that class name.
 * @author oshatil
 *
 */
public class Customer {
	private List <AnimalIF>animals;
	
	public Customer()
	{
		this.animals = new ArrayList <AnimalIF>();
	}
	public void buyAnimals()
	{
		AnimalStore store = new AnimalStore();
		animals.add(store.buyAnimal(Cat.class));
		animals.add(store.buyAnimal(Cat.class));
		animals.add(store.buyAnimal(Dog.class));
		animals.add(store.buyAnimal(Fish.class));
	}
	public void outputAnimalsYouOwn()
	{
		Iterator <AnimalIF>iter = this.animals.iterator();
		while (iter.hasNext()) {
			AnimalIF animal = iter.next();
			System.out.print("Animal name: " + animal.getName() + ". Animal Sound: " + animal.getSound());
			if (animal instanceof Cat) {
				System.out.print(". Number of flees: " + ((Cat)animal).getNumFlees() + "\n");
			}
			else if (animal instanceof Dog) {
				System.out.print(". Number of ticks: " + ((Dog)animal).getNumTicks() + "\n");
			}
			else if (animal instanceof Fish) {
				System.out.print(". Fin Size: " + ((Fish)animal).getFinSize() + "\n");
			}
		}
	}
}
