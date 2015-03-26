package concurrency.doublebuffering;

import java.io.File;
import java.util.List;

public class ZipArchiver implements ArchiverIF {
	private String archivePath;
	private boolean useBuffering;
	private List<File> files;
	private long maxFileSizeToCache;
	private static final long DEFAULT_BUFFER_SIZE = 1000000;
	
	public ZipArchiver(String archivePath) {
		this(archivePath, false, 0L);
	}
	public ZipArchiver(String archivePath, boolean useBuffering) {
		this(archivePath, useBuffering, DEFAULT_BUFFER_SIZE);
	}
	public ZipArchiver(String archivePath, boolean useBuffering, long maxFileSizeToCache) {
		this.archivePath = archivePath;
		this.maxFileSizeToCache = maxFileSizeToCache;
		this.useBuffering = useBuffering;
	}
	/**
	 * This method adds the file to the list of files to be archived.
	 */
	public void addFile(File file)  throws Exception {
		this.files.add(file);
	}
	/**
	 * This method performs the archiving.
	 */
	public void close() {
		// TODO: abstract base class should do all the caching so it can be shared by 
		// all subclasses
	}
	public void setArchivePath(String archivePath) {
		this.archivePath = archivePath;
	}
	public String getArchivePath() {
		return archivePath;
	}
	public void setUseBuffering(boolean useBuffering) {
		this.useBuffering = useBuffering;
	}
	public boolean isUseBuffering() {
		return useBuffering;
	}
	public List<File> getFiles() {
		return files;
	}
	public void setFiles(List<File> files) {
		this.files = files;
	}
	public long getMaxFileSizeToCache() {
		return maxFileSizeToCache;
	}
	public void setMaxFileSizeToCache(long maxFileSizeToCache) {
		this.maxFileSizeToCache = maxFileSizeToCache;
	}
}
