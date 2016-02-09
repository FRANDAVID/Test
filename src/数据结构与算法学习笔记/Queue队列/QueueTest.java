package 数据结构与算法学习笔记.Queue队列;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Rain on 16/2/9.
 *
 * Queue 接口 已经被linkedList实现了.
 */
public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        q.add(2);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        System.out.println("q.peek "+q.peek()+"=>"+q);
        System.out.println("q.poll "+q.poll()+"=>"+q);
        System.out.println("q.remove "+q.remove()+"=>"+q);
        System.out.println(q);
    }
}
