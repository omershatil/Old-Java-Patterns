package structural.facade;

/**
 * The Facade interface.
 * @author oshatil
 *
 */
public interface FileSenderFacadeIF {
	public void setFileList() throws Exception;
	public void setInstructions() throws Exception;
	public void start() throws Exception;
	public void stop() throws Exception;
	public void pause() throws Exception;
	public void resume() throws Exception;
	public SendStatus getStatus();
}
