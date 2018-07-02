package 线程池解决异常任务;

/**
 * Created by 11 on 2017/7/5.
 */
public class Plan {

    private SimpleTask task = new SimpleTask();
    public static void main(String[] args) {
        Plan plan = new Plan();
        plan.start();
    }

    public void start(){
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println(e.getMessage());
            start();
        });
        thread.start();
    }

    static class SimpleTask implements Runnable{

        private int task = 10;

        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+"--"+"启动");
            while(task>0){
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                if(System.currentTimeMillis()%3==0){
                    throw new RuntimeException("模拟异常");
                }
                System.out.println(threadName+"--"+"执行task"+task);
                task--;
            }
            System.out.println(threadName+"--"+"正常终止");
        }
    }
}