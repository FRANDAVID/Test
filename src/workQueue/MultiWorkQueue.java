package workQueue;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;


public class MultiWorkQueue implements WorkQueue
{
	private final int nThreads;
    private int queue_no = 0;
    private final PoolWorker[] threads;
    private BlockingDeque[] queue;
    private final int totalTasks;
    private AtomicInteger taskDone = new AtomicInteger(0);
	private boolean stopNow;
	
	private Object lock = new Object();
    
    /* 
     * constructor to initiate worker threads and 队列的实现 associated with it
     */
    public MultiWorkQueue(int nThreads, int totalTasks)
    {
        this.nThreads = nThreads;
        queue = new BlockingDeque[nThreads];
        threads = new PoolWorker[nThreads];
        for (int i=0; i<nThreads; i++) {
        	queue[i] = new LinkedBlockingDeque<Task>();
        }
        this.totalTasks = totalTasks;

    }
    
    public void startAllThreads() {
    	for (int i=0; i<nThreads; i++) {
            threads[i] = new PoolWorker(i);
            threads[i].start();
        }
    }

    /* 
     * Executes the given task in the future.
     * Queues the task and notifies the waiting thread. Also it makes
     * the Work assigner to wait if the queued task reaches to threshold
     */
    public void execute(Runnable r) {
    	
    	try {
			queue[queue_no++].putFirst(r);
			if(queue_no == nThreads){
				queue_no = 0;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
    
    /*
     * Clean-up the worker thread when all the tasks are done
     */
    public synchronized void doInterruptAllWaitingThreads() {
    	//Interrupt all the threads
    	for (int i=0; i<nThreads; i++) {
    		threads[i].interrupt();
    	}
    	synchronized(lock) {
    		lock.notify();
    	}
    }

	/*
     * Worker thread to execute user tasks
     */
    private class PoolWorker extends Thread {
    	
    	private int index;
    	
    	PoolWorker(int index) {
    		this.index = index;
    	}
    	
    	   	
    	/*
    	 * Method to retrieve task from worker 队列的实现 and start executing it.
    	 * This thread will wait for a task if there is no task in the 队列的实现.
    	 */
        public void run() {

            Runnable r = null;

            while (!stopNow) {
            	try {
					r = (Runnable) queue[index].takeLast();
				} catch (InterruptedException e1) {
					break;
				}
                try {
                    r.run();
                } catch ( java.lang.Throwable  e) {
                	e.printStackTrace();
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
