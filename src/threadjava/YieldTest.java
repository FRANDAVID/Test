package threadjava;
// YieldTest.java的源码
//“线程t1”在能被4整数的时候，并没有切换到“线程t2”。这表明，yield()虽然可以让线程由“运行状态”进入到“就绪状态”；
//但是，它不一定会让其它线程获取CPU执行权(即，其它线程进入到“运行状态”)，即使这个“其它线程”与当前调用yield()的线程具有相同的优先级。

//(01) wait()是让线程由“运行状态”进入到“等待(阻塞)状态”，而不yield()是让线程由“运行状态”进入到“就绪状态”。
//(02) wait()是会线程释放它所持有对象的同步锁，而yield()方法不会释放锁。
class ThreadATest extends Thread{
    public ThreadATest(String name){ 
        super(name); 
    } 
    public synchronized void run(){ 
        for(int i=0; i <10; i++){ 
            System.out.printf("%s [%d]:%d\n", this.getName(), this.getPriority(), i); 
            // i整除4时，调用yield
            if (i%4 == 0)
                Thread.yield();
        } 
    } 
} 

public class YieldTest{ 
    public static void main(String[] args){ 
    	ThreadATest t1 = new ThreadATest("t1"); 
    	ThreadATest t2 = new ThreadATest("t2"); 
        t1.start(); 
        t2.start();
    } 
}