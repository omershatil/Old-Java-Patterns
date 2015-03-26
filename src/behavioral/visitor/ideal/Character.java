package behavioral.visitor.ideal;

import java.util.HashMap;
/** all comments relate to the Visitor. For Composite comments see the Composite pattern
 * 
 * @author oshatil
 *
 */
public class Character extends AbstractComponentIdeal {
	protected char character;
	
	static private HashMap <Character, Character>charMap = new HashMap<Character, Character>();
	static private MutableCharacter mutableCharacter = new MutableCharacter(-1, 'a');
	
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
	public String getImageType()
	{
		return "";
	}
	public int getComponentPixelWidth() {
		return 23;
	}
	public int getComponentPixelHeight() {
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
