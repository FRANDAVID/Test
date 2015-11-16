package Collection;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

@SuppressWarnings("all")
public class LinkedListTest2 {
	
	//LinkedList中方法很多、但是没有一个是自己特有的、都是从抽象类或者接口中继承的、所以测试的时候就根据其继承或者实现的类、接口做为分类依据
	
	/**
	 * 测试从AbstractSequentialList中继承的方法
	 */
	private static void  testLinkedListFromASL(){
		System.out.println("Test methods: add(), addAll(Collection<?> extends E c), get(int index), set(int index, E e), remove(int index), clear(), clone()");
		
		//将"a", "b"添加到list中
		LinkedList<String> list = new LinkedList<String>();
		list.add("a");
		list.add("b");
		printList(list);
		
		//将含有"c", "d"的集合list2添加到list中
		LinkedList<String> list2 = new LinkedList<String>();
		list2.add("c");
		list2.add("d");
		list.addAll(list.size(), list2);
		printList(list);
	
		//将list中的最后一个元素设置成第一个元素
		list.set(list.size()-1, list.get(0));	//list.set(index, e)、list.get(index)都不推荐使用！
		printList(list);
		
		//将第一个"a"元素从list中移除
		list.remove(list.indexOf("a"));
		printList(list);
		
		//将list克隆一份
		LinkedList<String> cloneList = (LinkedList<String>) list.clone();
		printList(cloneList);
		
		//将list中元素清除
		list.clear();
		System.out.println("list elements : " + list + " list size : " + list.size());
		
	}

	/*
	 * 测试从Deque中继承的方法、双向队列Deque又是从Queue中继承的、所以方法比较多
	 * 但是有规律可循、LinkedList作为Deque的实现类、既可以作为先进先出的队列、也可以作为先进后出的堆栈
	 */
	
	/**
	 * 测试LinkedList以堆栈（后进先出、LIFO）形式使用的方法、
	 */
	private static void testLinkedListASStack(){
		System.out.println("Test methods: push(E e), poll(), peek()");
		LinkedList<String> stack = new LinkedList<String>();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		stack.push("d");
		printList(stack);
		
		/*
		 *	pop(), poll()都是取出stack栈顶元素 、区别就是当stack中没有元素时、stack.pop()抛异常、stack.poll()返回null		
		 */
		printStr("取出stack栈顶元素 str ：" + stack.pop());
		printStr("取出stack栈顶元素 str ：" + stack.poll());
		printStr("查看stack栈顶元素 str ：" + stack.peek());
		printList(stack);
	}

	/**
	 * 测试LinkedList以队列的形式（先进先出FIFO）形式使用的方法、
	 */
	private static void testLinkedListASQueue(){
		System.out.println("Test methods: add(e), offer(e),  remove(), poll(), element(), peek()" );
		LinkedList<String> queue = new LinkedList<String>();
		//add(e) 与方法off(e)等效
		queue.add("a");
		queue.add("b");
		queue.add("c");
		queue.offer("d");
		queue.offer("e");
		printList(queue);
		
		//他移除的是队列最前端的元素、最先进去的元素
		printStr(queue.remove());
		printStr(queue.poll());
		
		/*
		 * 下面两个方法都是查看第一个元素、区别就是当queue中没有元素时、queue.element()抛异常、queue.peek()返回null
		 */
		printStr(queue.element());
		printList(queue);
		printStr(queue.peek());
		printList(queue);
		
		queue.clear();
		printList(queue);
		printStr("the result of peek :  " + queue.peek());			//result: the result of peek :  null
		printStr("the result of element :  " + queue.element());	//result: java.util.NoSuchElementException
	}
	
	/**
	 * 测试LinkedList以双向链表的使用方法
	 */
	private static void testLinkedListDeque(){
		
		System.out.println("Test methods: addFirst(object), addLast(object), offerFirst(), offerLast(), getFirst(object), getLast(object), pollFirst(), pollLast(), peekFirst(), peekLast(), removeFirst(), removeLast()");
		
		//将 “abcdefg”初始化到LinkedList中
		LinkedList<String> list = new LinkedList<String>();
		
		//addFirst/addLast 没有返回值、offerFirst/offerLast返回true、内部都是调用Entry.addBefore()来添加的
		list.addFirst("c");
		list.offerFirst("b");
		list.offerFirst("a");
		list.addLast("d");
		list.addLast("e");
		list.offerLast("f");
		printList(list);
		
		/*	相同：
		 *			getFirst/getLast、peekFirst/peekLast方法都是获取第一个元素、
		 *	不同：
		 *			getXXX方法在list的size为0抛出异常、
		 *			peekXX方法在list的size为0返回null、	 
		 */
		printStr("list getFirst() obtains element: " + list.getFirst());
		printStr("list peekFirst() obtains element: " + list.peekFirst());
		printStr("list getLast() obtains element: " + list.getLast());
		printStr("list peekLast() obtains element: " + list.peekLast());
		printList(list);
		
		/*
		 * 相同：
		 * 			pollXXX、removeXXX都是获取第一个元素、并且将此元素从list中移除
		 * 不同：	
		 * 			removeXXX方法在list的size为0抛出异常、
		 * 			pollXXX方法在list的size为0返回null、
		 */
		
		printStr(list.pollFirst());
		printStr(list.removeFirst());
		printList(list);
		
		printStr(list.pollLast());
		printStr(list.removeLast());
		printList(list);
	}
	
	
	/**
	 * 测试LinkedList与Array之间的转换
	 */
	private static void testLinkedListOthersAPI(){
		String[] strArray = {"a", "b", "c", "d", "e"};
		LinkedList<String> strList = new LinkedList<String>(Arrays.asList(strArray));
		printList(strList);
		
		String[] array = strList.toArray(new String[0]);
		System.out.println(Arrays.toString(array));
		
	}
	
	private static void printList(LinkedList<String> list) {
		System.out.println(list);
	}
	private static void printStr(String str) {
		System.out.println(str);
	}
	public static void main(String[] args) {
		testLinkedListFromASL();
		testLinkedListASStack();
		testLinkedListASQueue();
		testLinkedListDeque();
		testLinkedListOthersAPI();
		testLinkedListOthersAPI();
	}
}