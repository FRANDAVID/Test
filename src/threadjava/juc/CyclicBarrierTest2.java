package threadjava.juc;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;

/**
 * 
    * @ClassName: CyclicBarrierTest2
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author weijin
    * @date 2015年11月18日
    *
    *结果说明：主线程中新建了5个线程，所有的这些线程都调用cb.await()等待。所有这些线程一直等待，
    *直到cb中所有线程都达到barrier时，执行新建cb时注册的Runnable任务。
 */
public class CyclicBarrierTest2 {

    private static int SIZE = 5;
    private static CyclicBarrier cb;
    public static void main(String[] args) {

        cb = new CyclicBarrier(SIZE, new Runnable () {
            public void run() {
                System.out.println("CyclicBarrier's parties is: "+ cb.getParties());
            }
        });

        // 新建5个任务
        for(int i=0; i<SIZE; i++)
            new InnerThread().start();
    }

    static class InnerThread extends Thread{
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");

                // 将cb的参与者数量加1
                cb.await();

                // cb的参与者数量等于5时，才继续往后执行
                System.out.println(Thread.currentThread().getName() + " continued.");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}