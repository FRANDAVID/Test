package 线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**当一个任务通过execute(Runnable)方法欲添加到线程池时：

        如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。

        如果此时线程池中的数量等于 corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。

        如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，建新的线程来处理被添加的任务。

        如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，那么通过 handler所指定的策略来处理此任务。也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、最大线程 maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。

        当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。
        https://mp.weixin.qq.com/s/aK2zJFPBCOtEwN8j40nvzg
 */
public class ThreadTest {

   public static void main(String[] args) {

       List<String> strList = new ArrayList<String>();
       for (int i = 0; i < 100; i++) {
           strList.add("String" + i);
       }
       int threadNum = strList.size() < 5 ? strList.size() : 5;
       ThreadPoolExecutor executor = new ThreadPoolExecutor(2, threadNum, 300,
               TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(3),
               new ThreadPoolExecutor.CallerRunsPolicy());
       for (int i = 0; i < threadNum; i++) {
           executor.execute(new PrintStringThread(i,strList,threadNum));
       }
       executor.shutdown();
   }
}

class PrintStringThread implements Runnable {

   private int num;

   private List<String> strList;

   private int threadNum;

   public PrintStringThread(int num, List<String> strList, int threadNum) {
       this.num = num;
       this.strList = strList;
       this.threadNum = threadNum;
   }

   public void run() {
       int length = 0;
       for(String str : strList){
           if (length % threadNum == num) {
               System.out.println("线程编号：" + num + "，字符串：" + str);
           }
           length ++;
       }
   }
}