package 线程池解决异常任务;
//http://www.cnblogs.com/yuhuihong19941210/p/5547501.html
public class Plan1 {
    
    private SimpleTask task = new SimpleTask();
    
    public static void main(String[] args) {
        Plan1 plan = new Plan1();
        plan.start();
    }
    public void start(){
        Thread thread = new Thread(task);
        //thread.setDaemon(true); //注释调 否则看不到输出
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(e.getMessage());
                start();
            }
        });
        thread.start();
    }
    
    class SimpleTask implements Runnable{
        private int task = 10;
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+"--"+"启动");
            while(task>0){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
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