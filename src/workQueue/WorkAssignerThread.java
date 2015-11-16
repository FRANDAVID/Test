package workQueue;


/*
 * Assigns task to worker queue
 */
public class WorkAssignerThread extends Thread {
	
	private final WorkQueue workQ;
	
	private int totalTasks;
	
	private int initialCount;
		
	// populate initial capacity
	public WorkAssignerThread(WorkQueue workQ, int total) {
		this.workQ = workQ;
		this.totalTasks = total;
		this.initialCount =  
			Math.min( (totalTasks/2), Integer.MAX_VALUE);
		Task t = new Task();
		for(int i=0;i<initialCount;i++) {
			workQ.execute(t);
		}
	}
	
	public void run() {
		Task t = new Task();
		
		for(int i=initialCount;i<totalTasks;i++) {
			workQ.execute(t);
		}
	}
}
