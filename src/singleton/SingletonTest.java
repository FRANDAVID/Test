package singleton;

/**
 * 对单例模式的测试
 * @author weijin
 *
 */
public class SingletonTest {

	public static void main(String[]args){
		SingletonThread st  = new SingletonThread();
		GoodSingletonThread gst = new GoodSingletonThread();
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		Thread t3 = new Thread(st);
		
		Thread gt1 = new Thread(gst);
		Thread gt2 = new Thread(gst);
		Thread gt3 = new Thread(gst);
		Thread gt4 = new Thread(gst);
		Thread gt5 = new Thread(gst);
		Thread gt6 = new Thread(gst);
		
		t1.start();t2.start();t3.start();
		
		gt1.start();
		gt2.start();
		gt3.start();
		gt4.start();
		gt5.start();
		gt6.start();
	}
}

class SingletonThread implements Runnable{

	public BadSingleton bs;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		bs = BadSingleton.getInstance();
		System.out.println("badSingleton=>"+bs);
	}
	

}