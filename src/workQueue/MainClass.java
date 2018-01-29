package workQueue;

// https://today.java.net/article/2011/06/14/method-reducing-contention-and-overhead-worker-queues-multithreaded-java-applications
public class MainClass {
	public static void main(String[] args) {
		
		if (args.length !=3) {
			System.out.println("Incorrect usage");
			System.out.println(" Usage -> java MainClass <Queue type> " +
					"<number of threads> <number of task>");
			System.exit(-1);
		}
		
		int type = Integer.parseInt(args[0]);
		int nThreads = Integer.parseInt(args[1]);
		int totalTasks = Integer.parseInt(args[2]);
		
		// Get Worker Queue based on users choice
		WorkQueue workQueue = WorkerQueueFactory.getWorkQueue(type, nThreads, totalTasks);
		
		
		// Start the work assigner thread
		WorkAssignerThread workAssigner = new WorkAssignerThread(workQueue, totalTasks); 
		 
		//Populate the task into worker 队列的实现
		workAssigner.start();

		long startTime = System.currentTimeMillis();
		workQueue.startAllThreads();
		
		try {
			workAssigner.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int tasksDone = workQueue.stopWhenAllTaskFinished();
		
		long endTime = System.currentTimeMillis();
		System.out.println("---------totaltime-----"+(endTime - startTime));
		System.out.println("---------Num of Tasks Executed-----"+tasksDone);
	}
}
