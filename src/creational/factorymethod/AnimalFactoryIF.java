package creational.factorymethod;

public interface AnimalFactoryIF {
	public Animal createAnimal(String animalType, String name) throws Exception;
}
