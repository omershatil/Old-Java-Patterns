package creational.prototype;

import java.io.*;

public interface AnimalIF extends Cloneable, Serializable {
	public String getName();
	public String getSound();
	public void setName(String name);
	public void setSound(String sound);
}
