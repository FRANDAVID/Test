package 线程池解决异常任务;
//https://blog.csdn.net/u013256816/article/details/50417822
public class NoCaughtThread
{
	public static void main(String[] args)
	{
		try
		{
			Thread thread = new Thread(new Task());
			thread.start();
		}
		catch (Exception e)
		{
			System.out.println("==Exception: "+e.getMessage());
		}
	}
}
 
class Task implements Runnable
{
	@Override
	public void run()
	{
		System.out.println(3/2);
		System.out.println(3/0);
		System.out.println(3/1);
	}
}
