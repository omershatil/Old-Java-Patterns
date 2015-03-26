package structural.facade;

import java.util.List;

/**
 * This class could be a private inner class of the facade class so that the clients
 * couldn't access it.
 * @author oshatil
 *
 */
public class SatelliteFileSender implements FileSenderIF {
	public void sendFile(String fileName) throws Exception
	{
		System.out.print("Sending file: " + fileName + "\n");
	}
	public void sendFiles(List <String>files) throws Exception
	{
		
	}
}
