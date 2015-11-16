package stack;


import java.util.LinkedList;
  
/**
 * 用LinkedList实现栈
 * 队列和栈区别：队列先进先出，栈先进后出。
 */
public class Stack<T>
{
    private LinkedList<T> storage = new LinkedList<T>();
  
    /** 入栈 */
    public void push(T v)
    {
        storage.addFirst(v);
//    	storage.addLast(v);
    }
  
    /** 出栈，但不删除 */
    public T peek()
    {
        return storage.getFirst();
    }
  
    /** 出栈，删除 */
    public T pop()
    {
        return storage.removeFirst();
    }
  
    /** 栈是否为空 */
    public boolean empty()
    {
        return storage.isEmpty();
    }
  
    /** 输出栈元素 */
    public String toString()
    {
        return storage.toString();
    }
      
    public static void main(String[] args)
    {
        Stack stack=new Stack<String>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.toString());
        Object obj=stack.peek();
        System.out.println(obj+"--"+stack.toString());
        obj=stack.pop();
        System.out.println(obj+"--"+stack.toString());
        System.out.println(stack.empty());
    }
}