package 线程池解决异常任务;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by 11 on 2017/7/5.
 */
public class Plan2 {
    private Plan.SimpleTask task = new Plan.SimpleTask();
    private MyFactory factory = new MyFactory(task);
    public static void main(String[] args) {
        Plan2 plan2 = new Plan2();
        ExecutorService pool = Executors.newSingleThreadExecutor(plan2.factory);
        pool.execute(plan2.task);
        pool.shutdown();
    }

    class MyFactory implements ThreadFactory {

        private Plan.SimpleTask task;

        public MyFactory(Plan.SimpleTask task) {
            super();
            this.task = task;
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setUncaughtExceptionHandler((t, e) -> {
                ExecutorService pool = Executors.newSingleThreadExecutor(new MyFactory(task));
                pool.execute(task);
                pool.shutdown();
            });
            return thread;
        }
    }
}