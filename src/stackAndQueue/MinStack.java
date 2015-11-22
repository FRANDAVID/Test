package stackAndQueue;


import java.util.Stack;

/**
 * Created by smyhvae on 2015/9/9.
 * 5、设计含最小函数min()的栈，要求min、push、pop、的时间复杂度都是O(1)。min方法的作用是：就能返回是栈中的最小值。【微信面试题】

普通思路：

一般情况下，我们可能会这么想：利用min变量，每次添加元素时，都和min元素作比较，这样的话，就能保证min存放的是最小值。
但是这样的话，会存在一个问题：如果最小的元素出栈了，那怎么知道剩下的元素中哪个是最小的元素呢？

改进思路：

这里需要加一个辅助栈，用空间换取时间。辅助栈中，栈顶永远保存着当前栈中最小的数值。
具体是这样的：原栈中，每次添加一个新元素时，就和辅助栈的栈顶元素相比较，如果新元素小，就把新元素的值放到辅助栈中，
如果新元素大，就把辅助栈的栈顶元素再copy一遍放到辅助栈的栈顶；原栈中，出栈时，

完整代码实现：
 */
public class MinStack {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>(); //辅助栈：栈顶永远保存stack中当前的最小的元素

    public void push(int data) {
        stack.push(data);  //直接往栈中添加数据

        //在辅助栈中需要做判断
        if (minStack.size() == 0 || data < minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.add(minStack.peek());   //【核心代码】peek方法返回的是栈顶的元素
        }
    }

    public int pop() throws Exception {
        if (stack.size() == 0) {
            throw new Exception("栈中为空");
        }

        int data = stack.pop();
        minStack.pop();  //核心代码
        return data;
    }

    public int min() throws Exception {
        if (minStack.size() == 0) {
            throw new Exception("栈中空了");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(3);
        stack.push(5);

        System.out.println(stack.min());
    }
}