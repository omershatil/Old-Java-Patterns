package creational.factorymethod;

/**
 * Factory Method. It's a Singleton since there should only be one instance of 
 * a factory.
 * @author oshatil
 *
 */
public class AnimalFactory implements AnimalFactoryIF{
	
	private static AnimalFactory instance = null;
	
	/**
	 * A singleton has to have at least one private constructor to prevent
	 * others from instantiating it
	 *
	 */
	private AnimalFactory()
	{
	}
	/**
	 * Lazy Instantiation is used if the Singleton may never be used. Create the 
	 * object on first call to <code>getInstance()<code>. 
	 * Declare the method synchronized if there may be more than one thread accessing
	 * this method.
	 * @return
	 */
	public static synchronized AnimalFactory getInstance()
	{
		if (instance == null) {
			instance = new AnimalFactory();
		}
		return instance;
	}
	/**
	 * TODO: shouldn't this method return AnimalIF and not Animal?
	 */
	public Animal createAnimal(String animalType, String name) throws Exception
	{
		if (animalType.equalsIgnoreCase(FactoryMethodsConstants.ANIMAL_TYPE.CAT.toString())) {
			return new Cat(name);
		}
		else if (animalType.equalsIgnoreCase(FactoryMethodsConstants.ANIMAL_TYPE.DOG.toString())) {
			return new Dog(name);
		}
		else if (animalType.equalsIgnoreCase(FactoryMethodsConstants.ANIMAL_TYPE.FISH.toString())) {
			return new Fish(name);
		}
		else {
			throw new Exception("Unrecognized animal. Life sucks");
		}
	}
}
