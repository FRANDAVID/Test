package 多线程.concurrent;

import java.util.concurrent.TimeUnit;
//java,线程操作,同步访问共享的可变数据
public class StopThread {
	private static /*volatile*/ boolean stopRequested;
	
	private static synchronized void requestStop(){
		stopRequested=true;
	}
	
	private static synchronized boolean stopReuqested(){
		return stopRequested;
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread backgroundThread =new Thread(new Runnable() {
			public void run() {
				long start=System.currentTimeMillis();
				int i=0;
				//while(!stopRequested){
				while(!stopReuqested()){
					i++;
				}
				long end=System.currentTimeMillis();
				System.out.println(end-start);
				System.out.println(i);
			}
		});
		backgroundThread.start();
		TimeUnit.SECONDS.sleep(1);
		//stopRequested=true;
		requestStop();
	}
}
