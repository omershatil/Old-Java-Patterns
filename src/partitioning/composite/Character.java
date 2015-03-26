package partitioning.composite;

import java.util.HashMap;

/**
 * A Component (not a composite). Implements the Flyweight pattern. It contains a map
 * of Character objects which are shared. If getCharacter() is called and the character
 * with the char value and font value already exist, return this object. Otherwise,
 * create a new one and add to list. Use a mutable object to do the get() on charMap
 * hash map so new objects don't need to be created for each object search.
 * @author מרים
 *
 */
public class Character extends AbstractHtmlpageComponent {
	protected char character;
	
	static private HashMap <Character, Character>charMap = new HashMap<Character, Character>();
	// avoid recreating a Character object by having a single instance of MutableCharacter
	static private MutableCharacter mutableCharacter = new MutableCharacter(-1, 'a');
	
	/**
	 * Private constructor since it's a Singleton
	 * @param font
	 * @param character
	 */
	private Character(int font, char character)
	{
		setFont(font);
		this.character = character;
	}
	static public Character getCharacter(int font, char c)
	{
		mutableCharacter.setCharacter(c);
		mutableCharacter.setFont(font);
		Character charObj = charMap.get(mutableCharacter);
		if (charObj == null) {
			charObj = new Character(font, c);
			charMap.put(charObj, charObj);
		}
		return charObj;
	}
	public CompositeConstants.ImageType getImageType()
	{
		return CompositeConstants.ImageType.none;
	}
	public int getComponentPixelWidth() {
		// determine dimension by font size and character
		return 23;
	}
	public int getComponentPixelHeight() {
		// determine dimension by font size and character
		return 23;
	}
	public char getCharacter() {
		return character;
	}
	public int hashCode()
	{
		return this.character;
	}
	public boolean equals(Object obj)
	{
		if (obj instanceof Character && 
				this.character == ((Character)obj).getCharacter() &&
				this.getFont() == ((Character)obj).getFont())
			return true;
		return false;
	}
	public void print()
	{
		System.out.print("	Character component. Font: " + getFont() + ". Character: " + this.character + "\n");
	}

	/**
	 * This class is used in the equals() method which is called by the get() method on the charMap
	 * hash map. We don't want to recreate an object every time, so we create a single mutable
	 * object and call its set() methods before calling get() on charMap (see getCharacter() above)
	 * @author oshatil
	 *
	 */
	private static class MutableCharacter extends Character {
		
		MutableCharacter(int font, char c)
		{
			super(font, c);
		}
		public void setCharacter(char c)
		{
			this.character = c;
		}
	}
}
