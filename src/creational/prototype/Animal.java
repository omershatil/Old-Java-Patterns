package creational.prototype;

public abstract class Animal implements AnimalIF {
	private String name;
	private String sound;
	
	public Animal(String name, String sound)
	{
		this.name = name;
		this.sound = sound;
	}
	/**
	 * Implement the public version of this function so that it can be called
	 * by other objects
	 */
	public Animal clone() {
		Animal animal = null;
		try {
			animal = (Animal)super.clone();
		}
		catch (CloneNotSupportedException cnse) {
			// should never happen
			throw new InternalError();
		}
		return animal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSound() {
		return sound;
	}
	public void setSound(String sound) {
		this.sound = sound;
	}
	
}
