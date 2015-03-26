package concurrency.doublebuffering;

import java.io.File;

public interface ArchiverIF {
	public void addFile(File file) throws Exception;
}
