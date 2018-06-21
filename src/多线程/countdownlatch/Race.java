package 多线程.countdownlatch;
import java.util.concurrent.CountDownLatch;  

/*
 * 1. 有五个人，一个裁判。这五个人同时跑，裁判开始计时，五个人都到终点了，
 * 裁判喊停，然后统计这五个人从开始跑到最后一个撞线用了多长时间。
    
    *
 */
public class Race {  

    public static void main(String[] args) {  
        final int num = 5;  
        final CountDownLatch begin = new CountDownLatch(1);  
        final CountDownLatch end = new CountDownLatch(num);  

        for (int i = 0; i < num; i++) {  
            new Thread(new AWorker(i, begin, end)).start();  
        }  

        // judge prepare...  
        try {  
            Thread.sleep((long) (Math.random() * 5000));  
        } catch (InterruptedException e1) {  
            e1.printStackTrace();  
        }  

        System.out.println("judge say : run !");  
        begin.countDown();  
        long startTime = System.currentTimeMillis();  

        try {  
            end.await();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } finally {  
            long endTime = System.currentTimeMillis();  
            System.out.println("judge say : all arrived !");  
            System.out.println("spend time: " + (endTime - startTime));  
        }  

    }  

}  

class AWorker implements Runnable {  
    final CountDownLatch begin;  
    final CountDownLatch end;  
    final int id;  

    public AWorker(final int id, final CountDownLatch begin,  
            final CountDownLatch end) {  
        this.id = id;  
        this.begin = begin;  
        this.end = end;  
    }  

    @Override  
    public void run() {  
        try {  
            System.out.println(this.id + " ready !");  
            begin.await();  
            // run...  
            Thread.sleep((long) (Math.random() * 10000));  
        } catch (Throwable e) {  
            e.printStackTrace();  
        } finally {  
            System.out.println(this.id + " arrived !");  
            end.countDown();  
        }  
    }  

}  