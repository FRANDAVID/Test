package 多线程.thread;
public class JoinTest implements Runnable{  
      
    public static int a = 0;  
  
    public void run() {  
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for (int k = 0; k < 5; k++) { 
        	System.out.println(k);
        }  
        System.out.println("子线程结束......");
		
    }  
  
    public static void main(String[] args) throws Exception {  
        Runnable r = new JoinTest();  
        Thread t = new Thread(r);  
        t.start(); 
        t.join();//如果不加上join方法，那么for循环还没执行完，主线程就继续向下执行了。
        		 //当main线程调用t.join时，main线程等待t线程执行完之后在继续向下执行
        System.out.println("主线程结束");  
    }         
}  