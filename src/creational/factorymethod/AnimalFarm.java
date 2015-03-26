package creational.factorymethod;

public class AnimalFarm {
	public Animal createAnimal(String animalType, String name) throws Exception
	{
		return AnimalFactory.getInstance().createAnimal(animalType, name);
	}
}
