package structural.facade;

import java.util.List;

public interface FileSenderIF {
	public void sendFile(String fileName) throws Exception;
	public void sendFiles(List <String>files) throws Exception;
}
