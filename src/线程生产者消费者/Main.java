package 线程生产者消费者;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

//启动一个消息分发线程。在这个线程里子队列自动去总队列里获取消息
public class Main {
    static class DispatchMessageTask implements Runnable{
        //分发消息，负责把消息从大队列塞到小队列里
        @Override
        public void run() {
            BlockingQueue<Message> subQueue;
            while(true){
                try {
                    //如果没有数据，那么阻塞在这里
                    Message msg = MsgQueueManager.messageQueue.take();
                    while( (subQueue = getSubQueue()) == null){//没有获取到子队列，等待
                        try{
                            Thread.sleep(1000);
                        }catch(InterruptedException e){
                            Thread.currentThread().interrupt();
                        }
                    }
                    //把消息放到小队列里
                    try{
                        subQueue.put(msg);
                    }catch(InterruptedException e){
                        Thread.currentThread().interrupt();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        }
        
    }
    //使用散列（hash）算法获取一个子队列
    public static BlockingQueue<Message> getSubQueue(){
        List<BlockingQueue<Message>> subMsgQueues = new ArrayList();//假装这是一个全局的子队列
        int errorCount = 0;
        for(;;){
            if(subMsgQueues.isEmpty()){
                return null;
            }
            int index = (int)(System.nanoTime() % subMsgQueues.size());
            try{
                return subMsgQueues.get(index);
            }catch(Exception e){
                //出现错误，在获取队列大小之后，队列进行了一次删除操作
                if(++errorCount < 3){
                    continue;
                }
            }
        }
    }
}