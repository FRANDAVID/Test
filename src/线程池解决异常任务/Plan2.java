package 线程池解决异常任务;

import java.util.concurrent.*;

public class Plan2 {
    private SimpleTask task = new SimpleTask();
    public static void main(String[] args) {
        Plan2 plan = new Plan2();
        start(plan.task);
    }
    
    public static void start(SimpleTask task){
        ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();
        ScheduledFuture<?> future = pool.scheduleAtFixedRate(task, 0, 1000, TimeUnit.MILLISECONDS);
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
            start(task);
        }finally {
            pool.shutdown();
        }
    }
    
    class SimpleTask implements Runnable{
        private volatile int count = 0;
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+"--"+"启动");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(System.currentTimeMillis()%3==0){
                throw new RuntimeException("模拟异常");
            }
            System.out.println(threadName+"--"+"执行task"+count);
            count++;
            System.out.println(threadName+"--"+"正常终止");
        }
    }
}