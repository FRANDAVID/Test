package threadjava;
// SleepTest.java的源码
//sleep() 定义在Thread.java中。
//sleep() 的作用是让当前线程休眠，即当前线程会从“运行状态”进入到“休眠(阻塞)状态”。
//sleep()会指定休眠时间，线程休眠的时间会大于/等于该休眠时间；在线程重新被唤醒时，
//它会由“阻塞状态”变成“就绪状态”，从而等待cpu的调度执行。
class ThreadASleep extends Thread{
    public ThreadASleep(String name){ 
        super(name); 
    } 
    public synchronized void run() { 
        try {
            for(int i=0; i <10; i++){ 
                System.out.printf("%s: %d\n", this.getName(), i); 
                // i能被4整除时，休眠100毫秒
                if (i%4 == 0)
                    Thread.sleep(100);
            } 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } 
} 

public class SleepTest{ 
    public static void main(String[] args){ 
    	ThreadASleep t1 = new ThreadASleep("t1"); 
        t1.start(); 
    } 
}