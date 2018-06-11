package 集合;
//from http://blog.csdn.net/xiao__gui/article/details/8934832
/**
 * 再用线程安全的Vector来进行测试，上面代码改变一处，test()方法中
 * List<Object> list = new Vector<Object>();  
 */
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class ThreadSafeTest
{
	public static void main(String[] args)
	{
		// 进行10次测试
		for(int i = 0; i < 10; i++)
		{
			test();
		}
	}
	
	public static void test()
	{
		// 用来测试的List
		List<Object> list = new ArrayList<Object>();
		
		// 线程数量(1000)
		int threadCount = 1000;
		
		// 用来让主线程等待threadCount个子线程执行完毕
		CountDownLatch countDownLatch = new CountDownLatch(threadCount);
		
		// 启动threadCount个子线程
		for(int i = 0; i < threadCount; i++)
		{
			Thread thread = new Thread(new MyThread(list, countDownLatch));
			thread.start();
		}
		
		try
		{
			// 主线程等待所有子线程执行完成，再向下执行
			countDownLatch.await();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		// List的size
		System.out.println(list.size());
	}
}

class MyThread implements Runnable
{
	private List<Object> list;
	
	private CountDownLatch countDownLatch;
	
	public MyThread(List<Object> list, CountDownLatch countDownLatch)
	{
		this.list = list;
		this.countDownLatch = countDownLatch;
	}
	
	public void run()
	{
		// 每个线程向List中添加100个元素
		for(int i = 0; i < 100; i++)
		{
			list.add(new Object());
		}
		
		// 完成一个子线程
		countDownLatch.countDown();
	}
}