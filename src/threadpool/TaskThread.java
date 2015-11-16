package threadpool;


public class TaskThread extends Thread {
	// 该线程所属的线程池
	private ThreadPoolService service;
	public TaskThread(ThreadPoolService tps) {
		service = tps;
	}
	public void run() {
		// 在线程池运行的状态下执行任务队列中的任务
		while (service.isRunning()) {
			TaskQueue queue = service.getTaskQueue();
			Task task = queue.getTask();
			if (task != null) {
				task.deal();
			}
			queue.finishTask(task);
		}
	}
}