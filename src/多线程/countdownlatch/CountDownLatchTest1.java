package thread.countdownlatch;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CountDownLatchTest1 {

    private static int LATCH_SIZE = 5;
    private static CountDownLatch doneSignal;
    public static void main(String[] args) {

        try {
            doneSignal = new CountDownLatch(LATCH_SIZE);
            System.out.println("比赛开始");

            // 新建5个任务
            for(int i=0; i<LATCH_SIZE; i++)
                new InnerThread().start();
            // "主线程"等待线程池中5个任务的完成
            doneSignal.await();


            System.out.println("比赛结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class InnerThread extends Thread{
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
                // 将CountDownLatch的数值减1
                doneSignal.countDown();
            	System.out.println("运动员"+Thread.currentThread().getName()+"已经开始起跑");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}