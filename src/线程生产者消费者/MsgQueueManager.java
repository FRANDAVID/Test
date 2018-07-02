package 线程生产者消费者;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

//总消息队列管理
public class MsgQueueManager implements IMsgQueue {
    public final static BlockingQueue<Message> messageQueue = new LinkedTransferQueue<Message>();
    
    @Override
    public void put(Message msg) {
        try {
            messageQueue.put(msg);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Message take() {
        try {
            return messageQueue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return null;
    }

}