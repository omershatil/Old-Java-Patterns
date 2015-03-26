package concurrency.scheduler;

import java.util.ArrayList;

/**
 * This class is used to explicitly schedule single threaded access to a
 * resource.
 */
public class Scheduler {
    // The runningThread variable is null when the managed resource is
    // not busy.  It contains a reference to the thread that is using
    // the resource when the resource is busy.
    private Thread runningThread;

    // An invariant for this class is that a request and its
    // corresponding thread are only in waitingRequests and
    // waitingThreads while its call to enter is pending.
    private ArrayList<ScheduleOrdering> waitingRequests = new ArrayList<ScheduleOrdering>();
    private ArrayList<Thread> waitingThreads = new ArrayList<Thread>();

    /**
     * This method is called before a thread starts using a managed
     * resource.  This method does not return until the managed
     * resource is not busy and this Scheduler object decides it is the
     * method call's turn to return.
     * @exception InterruptedException if this thread has been interrupted.
     */
    public void enter(ScheduleOrdering s) throws InterruptedException {
        Thread thisThread = Thread.currentThread();

        // For the case when the managed resource is not busy,
        // synchronize on this object to ensure that two concurrent
        // calls to enter do not both return immediately.
        synchronized (this) {
            if (runningThread == null) {
                runningThread = thisThread;
                return;
            } // if
            waitingThreads.add(thisThread);
            waitingRequests.add(s);
        } // synchronized (this)
        synchronized (thisThread) {
            while (thisThread != runningThread) {
                thisThread.wait();
            } // while
        } // synchronized (thisThread)
        synchronized (this) {
            int i = waitingThreads.indexOf(thisThread);
            waitingThreads.remove(i);
            waitingRequests.remove(i);
        } // synchronized (this)
    } // enter(ScheduleOrdering)

    /**
     * This method is called to indicate that the current thread is
     * finished with the managed resource.
     * @exception IllegalStateException if called by a thread that is
     *            not the thread using the managed resource.
     */
    synchronized public void done() {
        if (runningThread != Thread.currentThread())
          throw new IllegalStateException("Wrong Thread");
        int waitCount = waitingThreads.size();
        if (waitCount <= 0)
          runningThread = null;
        else if (waitCount == 1) {
        	// only one thread waiting. no need to compare time stamps
            runningThread = (Thread)waitingThreads.get(0);
        } else {
        	// 2 threads or more - need to compare timestamps to see who is next
            int next = waitCount - 1;
            ScheduleOrdering nextRequest;
            nextRequest = (ScheduleOrdering)waitingRequests.get(next);
            for (int i = waitCount-2; i>=0; i--) {
                ScheduleOrdering r;
                r = (ScheduleOrdering)waitingRequests.get(i);
                if (r.scheduleBefore(nextRequest)) {
                    next = i;
                    nextRequest = (ScheduleOrdering)waitingRequests.get(next);
                } // if
            } // for
            runningThread = (Thread)waitingThreads.get(next);
        } // if waitCount
        synchronized (runningThread) {
            runningThread.notifyAll();
        } // synchronized (runningThread)
    } // done()
} // class Scheduler
