package productContomerBlock;
 
 
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
 
 
public class ProducerConsumerService {
 
    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce messages in 队列的实现
        new Thread(producer).start();
        //starting consumer to consume messages from 队列的实现
        new Thread(consumer).start();
        System.out.println("Producer and Consumer has been started");
    }
 
}