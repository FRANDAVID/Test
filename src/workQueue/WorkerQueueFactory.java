package workQueue;


public class WorkerQueueFactory {
	
	public static WorkQueue getWorkQueue(int type, int nthreads, int totalTasks) {
		switch(type) {
			case 1:
					return new SimpleWorkQueue(nthreads, totalTasks);
			
			case 2:
					return new MultiWorkQueue(nthreads, totalTasks);
				
			case 3:
					return new WorkStealingQueue(nthreads, totalTasks);
				
			default:
					throw new RuntimeException("incorrect input");
		}
	}
}