package thread.demoTread;

class Demo implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("aaaaa");
		}
	}
	
}
public class DemoThreadTest {
	public static void main(String[]args){
		
	Demo d1 = new Demo();
	Thread t1 = new Thread(d1);
	t1.setDaemon(true);
	t1.start();
	}
	
}
