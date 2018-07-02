package 线程生产者消费者;

public interface IMsgQueue {
    void put(Message msg);
    Message take();
}