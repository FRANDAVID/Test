package thread.thread;

public class Common {

	public synchronized void synchronizedMethod1() {
		System.out.println("synchronizedMethod1 called");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("synchronizedMethod1 done");
	}

	public void method1() {
		System.out.println("Method 1 called");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Method 1 done");
	}
}
