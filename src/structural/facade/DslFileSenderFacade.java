package structural.facade;

/**
 * @author oshatil
 *
 */
public class DslFileSenderFacade implements FileSenderFacadeIF {
	public DslFileSenderFacade()
	{
	}
	public void setFileList() throws Exception
	{
		
	}
	public void setInstructions() throws Exception
	{
		
	}
	public void start() throws Exception
	{
		DslFileSender fileSender = new DslFileSender();
		fileSender.sendFile("DslFile.exe");
	}
	public void stop() throws Exception
	{
		
	}
	public void pause() throws Exception
	{
		
	}
	public void resume() throws Exception{
		
	}
	public SendStatus getStatus()
	{
		return new SendStatus();
	}
}
