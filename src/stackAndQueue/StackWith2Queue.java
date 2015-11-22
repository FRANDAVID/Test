package stackAndQueue;


import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 4、两个队列实现一个栈：

思路：

将1、2、3依次入队列一， 然后最上面的3留在队列一，将下面的2、3入队列二，将3出队列一，
此时队列一空了，然后把队列二中的所有数据入队列一；将最上面的2留在队列一，将下面的3入队列二。。。依次循环。
 */
public class StackWith2Queue {

    Queue<Integer> queue1 = new ArrayDeque<Integer>();
    Queue<Integer> queue2 = new ArrayDeque<Integer>();

    //方法：入栈操作
    public void push(int data) {
        queue1.add(data);
    }

    //方法：出栈操作
    public int pop() throws Exception {
        int data;
        if (queue1.size() == 0) {
            throw new Exception("栈为空");
        }

        while (queue1.size() != 0) {
            if (queue1.size() == 1) {
                data = queue1.poll();
                while (queue2.size() != 0) {  //把queue2中的全部数据放到队列一中
                    queue1.add(queue2.poll());
                    return data;
                }
            }
            queue2.add(queue1.poll());
        }
        throw new Exception("栈为空");//不知道这一行的代码是什么意思
    }

    public static void main(String[] args) throws Exception {
    	StackWith2Queue stack = new StackWith2Queue();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.push(4);
    }
}