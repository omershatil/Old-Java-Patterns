package concurrency.readwritelock;

import java.util.ArrayList;
import java.util.List;

/**
 * Instances of this class manage read and write locks.
 */
public class ReadWriteLock {
    private int waitingForReadLock = 0;
    private int outstandingReadLocks = 0;

    // The thread that has the write lock or null.
    private Thread writeLockedThread;

    // Threads waiting to get a write lock are tracked in this ArrayList
    // to ensure that write locks are issued in the same order they are
    // requested.
    private List<Thread> waitingForWriteLock = new ArrayList<Thread>();

    /**
     * Issue a read lock if there is no outstanding write lock or
     * threads waiting to get a write lock.
     */
    synchronized public void readLock() throws InterruptedException {
        waitingForReadLock++;
        while (writeLockedThread != null) {
            wait();
        }
        waitingForReadLock--;
        outstandingReadLocks++;
    } 

    /**
     * Issue a write lock if there are no outstanding read or write
     * locks.
     */
    public void writeLock() throws InterruptedException {
        Thread thisThread;
        synchronized (this) {
            if (writeLockedThread==null && outstandingReadLocks==0) {
                writeLockedThread = Thread.currentThread();
                return;
            } 
            thisThread = Thread.currentThread();
            waitingForWriteLock.add(thisThread);
        } 
        synchronized (thisThread) {
            while (thisThread != writeLockedThread) {
                thisThread.wait();
            } 
        } 
        synchronized (this) {
            int i = waitingForWriteLock.indexOf(thisThread);
            waitingForWriteLock.remove(i);
        } 
    } 

    /**
     * Threads call this method to relinquish a lock that they
     * previously got from this object.
     * @exception IllegalStateException if called when there are no
     *            outstanding locks or there is a write lock issued to a
     *            different thread.
     */
    synchronized public void done() {
        if (outstandingReadLocks > 0) {
            outstandingReadLocks--;
            if ( outstandingReadLocks==0
                 && waitingForWriteLock.size()>0) {
                writeLockedThread = (Thread)waitingForWriteLock.get(0);
                synchronized (writeLockedThread) {
                    writeLockedThread.notifyAll();
                } 
            } 
        } else if (Thread.currentThread() == writeLockedThread) {
            if ( outstandingReadLocks==0
                 && waitingForWriteLock.size()>0) {
                writeLockedThread = (Thread)waitingForWriteLock.get(0);
                synchronized (writeLockedThread) {
                    writeLockedThread.notifyAll();
                } 
            } else {
                writeLockedThread = null;
                if (waitingForReadLock > 0)
                  notifyAll();
            } 
        } else {
            throw new IllegalStateException("Thread does not have lock");
        } 
    } 
} 
