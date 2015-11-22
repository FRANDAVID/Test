package threadpool.Excutor;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ExecutionException;
//结果说明：
//在主线程main中，通过newSingleThreadExecutor()新建一个线程池。接着创建Callable对象c1，
//然后再通过pool.submit(c1)将c1提交到线程池中进行处理，并且将返回的结果保存到Future对象f1中。然后，
//我们通过f1.get()获取Callable中保存的结果；最后通过pool.shutdown()关闭线程池。


class MyCallable implements Callable {

    @Override 
    public Integer call() throws Exception {
        int sum    = 0;
        // 执行任务
        for (int i=0; i<100; i++)
            sum += i;
        //return sum; 
        return Integer.valueOf(sum);
    } 
}

public class CallableTest1 {

    public static void main(String[] args) 
        throws ExecutionException, InterruptedException{
        //创建一个线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
        //创建有返回值的任务
        Callable c1 = new MyCallable();
        //执行任务并获取Future对象 
        Future f1 = pool.submit(c1);
        // 输出结果
        System.out.println(f1.get()); 
        //关闭线程池 
        pool.shutdown(); 
    }
}