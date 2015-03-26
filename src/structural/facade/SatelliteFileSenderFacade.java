package structural.facade;

public class SatelliteFileSenderFacade implements FileSenderFacadeIF {
	public SatelliteFileSenderFacade()
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
		SatelliteFileSender fileSender = new SatelliteFileSender();
		fileSender.sendFile("SatelliteFile.exe");
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
