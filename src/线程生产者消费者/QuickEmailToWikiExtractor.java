package 线程生产者消费者;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QuickEmailToWikiExtractor{
    private ThreadPoolExecutor threadPool;
    private BlockingQueue<ExchangeEmailShallowDTO> emailQueue;
    
    public QuickEmailToWikiExtractor() {
        emailQueue = new LinkedBlockingQueue<ExchangeEmailShallowDTO>();
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        threadPool = new ThreadPoolExecutor(corePoolSize, corePoolSize,101, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2000));
    }
    // 每五分钟执行一次
    public void exetract(){
        System.out.println("开始");
        long start = System.currentTimeMillis();
        
        //抽取所有的邮件放到队列中
        new ExtractEmailTask().start();
        //把队列的文章插入Wiki
        insertToWiki();
        
        long end = System.currentTimeMillis();
        double cost = (end - start) / 1000;
        System.out.println("完成，花费时间=" + cost + "秒。");
    }
    // 把队列中的文章插入到Wiki
    private void insertToWiki(){
        while(true){
            //2s读取不到就退出
            ExchangeEmailShallowDTO email;
            try {
                email = emailQueue.poll(2,  TimeUnit.SECONDS);
                if(email == null){
                    break;
                }
                threadPool.execute(new InsertToWikiTask(email));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    protected void extractEmail(){
        List<ExchangeEmailShallowDTO> allEmails = new ArrayList();//这里是抽取出的所有邮件
        int i = 0;
        while(i++<10){
            allEmails.add(new ExchangeEmailShallowDTO());
        }
        if(allEmails == null){
            return;
        }
        for(ExchangeEmailShallowDTO email: allEmails){
            emailQueue.offer(email);
        }
    }
    //抓取邮件线程
    class ExtractEmailTask extends Thread{
        public void run(){
            System.out.println("抽取邮件。。。");
            extractEmail();
        }
    }
    class InsertToWikiTask implements Runnable{
        private ExchangeEmailShallowDTO email;
        public InsertToWikiTask(ExchangeEmailShallowDTO email){
            this.email = email;
        }
        public void run() {
            System.out.println(Thread.currentThread().getName() + "把一个邮件插入到Wiki=" + System.currentTimeMillis());
        }
    }
    
    public static void main(String[] args) {
        QuickEmailToWikiExtractor mail = new QuickEmailToWikiExtractor();
        mail.exetract();
    }
}

class ExchangeEmailShallowDTO{
    
}
