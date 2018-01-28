package 栈的几种实现;


public class Stack2 {

    public Node head;
    public Node current;

    //方法：入栈操作
    public void push(int data) {
        if (head == null) {
            head = new Node(data);
            current = head;
        } else {
            Node node = new Node(data);
            node.pre = current;//current结点将作为当前结点的前驱结点
            current = node;  //让current结点永远指向新添加的那个结点
        }
    }

    public Node pop() {
        if (current == null) {
            return null;
        }

        Node node = current; // current结点是我们要出栈的结点
        current = current.pre;  //每出栈一个结点后，current后退一位
        return node;

    }

    class Node {
        int data;
        Node pre;  //我们需要知道当前结点的前一个结点

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        Stack2 stack = new Stack2();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop().data);
        System.out.println(stack.pop().data);
        System.out.println(stack.pop().data);
    }

}