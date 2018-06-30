package 线程池;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//https://www.cnblogs.com/nayitian/p/3262031.html
public class ThreadPoolTest3 {
    static class MyThread implements Runnable {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            // 做点事情
            try {
                Thread.sleep(1000);
                    
                System.out.println(name + " finished job!") ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // 创建线程池，为了更好的明白运行流程，增加了一些额外的代码
//        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(2);
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
//        BlockingQueue<Runnable> queue = new PriorityBlockingQueue<Runnable>();
//        BlockingQueue<Runnable> queue = new SynchronousQueue<Runnable>();

        
        // AbortPolicy/CallerRunsPolicy/DiscardOldestPolicy/DiscardPolicy
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 5, TimeUnit.SECONDS,
                queue, new ThreadPoolExecutor.AbortPolicy());

        // 向线程池里面扔任务
        for (int i = 0; i < 10; i++) {
            System.out.println("当前线程池大小[" + threadPool.getPoolSize() + "],当前队列大小[" + queue.size() + "]");

            threadPool.execute(new MyThread("Thread" + i));
        }
        // 关闭线程池
        threadPool.shutdown();
    }
}