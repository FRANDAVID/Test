package workQueue;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;


public class SimpleWorkQueue implements WorkQueue
{
	static final int QUEUE_THRESHOLD = 300;
    private final int nThreads;
    private final PoolWorker[] threads;
    private final BlockingDeque queue;
    private final int totalTasks;
    private AtomicInteger taskDone = new AtomicInteger(0);
    private boolean stopNow;
    
    private Object lock = new Object();;
    
    /* 
     * constructor to initiate worker threads and 队列的实现 associated with it
     */
    public SimpleWorkQueue(int nThreads, int totalTasks)
    {
        this.nThreads = nThreads;
        queue = new LinkedBlockingDeque<Task>();
        threads = new PoolWorker[nThreads];
        this.totalTasks = totalTasks;
    }
    
    public void startAllThreads() {
    	for (int i=0; i<nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    /* 
     * Executes the given task in the future.
     * Queues the task and notifies the waiting 多线程. Also it makes
     * the Work assigner to wait if the queued task reaches to threshold
     */
    public void execute(Runnable r) {
    	try {
			queue.putFirst(r);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    /*
     * Clean-up the worker 多线程 when all the tasks are done
     */
    public void doInterruptAllWaitingThreads() {
    	//Interrupt all the threads
    	for (int i=0; i<nThreads; i++) {
    		threads[i].interrupt();
    	}
    	
    	synchronized(lock) {
    		lock.notify();
    	}
    }

    /*
     * Worker 多线程 to execute user tasks
     */
    private class PoolWorker extends Thread {
    	/*
    	 * Method to retrieve task from worker 队列的实现 and start executing it.
    	 * This 多线程 will wait for a task if there is no task in the 队列的实现.
    	 */
        public void run() {

            Runnable r = null;

            while (!stopNow) {
            	try {
					r = (Runnable) queue.takeLast();
				} catch (InterruptedException e1) {
					break;
				}
                try {
                    r.run();
                } catch ( java.lang.Throwable  e) {
                }
                
                if( taskDone.addAndGet(1)== totalTasks) {
                	stopNow = true;
                	doInterruptAllWaitingThreads();
                	break;
                }
            }
            
            
        }
    }

	public int stopWhenAllTaskFinished() {
		// wait for threads to complete running the tasks
		synchronized(lock) {
			try {
				lock.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return taskDone.get();
	}
}
