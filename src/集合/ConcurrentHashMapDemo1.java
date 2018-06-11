package 集合;
import java.util.*;
import java.util.concurrent.*;

/*
 *   ConcurrentHashMap是“线程安全”的哈希表，而HashMap是非线程安全的。
 *
 *   下面是“多个线程同时操作并且遍历map”的示例
 *   (01) 当map是ConcurrentHashMap对象时，程序能正常运行。
 *   (02) 当map是HashMap对象时，程序会产生ConcurrentModificationException异常。
 *
 * @author skywang
 * 总结：ConcurrentHashMap是线程安全的哈希表，它是通过“锁分段”来实现的。
 * ConcurrentHashMap中包括了“Segment(锁分段)数组”，每个Segment就是一个哈希表，而且也是可重入的互斥锁。
 * 第一，Segment是哈希表表现在，Segment包含了“HashEntry数组”，而“HashEntry数组”中的每一个HashEntry元素是一个单向链表。
 * 即Segment是通过链式哈希表。
 * 第二，Segment是可重入的互斥锁表现在，Segment继承于ReentrantLock，而ReentrantLock就是可重入的互斥锁。
对于ConcurrentHashMap的添加，删除操作，在操作开始前，线程都会获取Segment的互斥锁；操作完毕之后，才会释放。
而对于读取操作，它是通过volatile去实现的，HashEntry数组是volatile类型的，而volatile能保证“即对一个volatile变量的读，
总是能看到（任意线程）对这个volatile变量最后的写入”，即我们总能读到其它线程写入HashEntry之后的值。
 以上这些方式，就是ConcurrentHashMap线程安全的实现原理。
 */
public class ConcurrentHashMapDemo1 {

    // TODO: map是HashMap对象时，程序会出错。
    //private static Map<String, String> map = new HashMap<String, String>();
    private static Map<String, String> map = new ConcurrentHashMap<String, String>();
    public static void main(String[] args) {
    
        // 同时启动两个线程对map进行操作！
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String key, value;
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            key = (String)entry.getKey();
            value = (String)entry.getValue();
            System.out.print(key+" - "+value+", ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }
        @Override
        public void run() {
                int i = 0;
            while (i++ < 6) {
                // “线程名” + "-" + "序号"
                String val = Thread.currentThread().getName()+i;
                map.put(String.valueOf(i), val);
                // 通过“Iterator”遍历map。
                printAll();
            }
        }
    }
}