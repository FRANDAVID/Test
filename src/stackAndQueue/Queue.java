package stackAndQueue;
public class Queue {
    public Node head;
    public Node curent;

    //方法：链表中添加结点
    public void add(int data) {
        if (head == null) {
            head = new Node(data);
            curent = head;
        } else {
            curent.next = new Node(data);
            curent = curent.next;
        }
    }

    //方法：出队操作
    public int pop() throws Exception {
        if (head == null) {
            throw new Exception("队列为空");
        }

        Node node = head;  //node结点就是我们要出队的结点
        head = head.next; //出队之后，head指针向下移

        return node.data;

    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) throws Exception {
        Queue queue = new Queue();
        //入队操作
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        //出队操作
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}
