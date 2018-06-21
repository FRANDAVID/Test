package 多线程.hashmap;
import java.util.HashMap;
//http://blog.csdn.net/xuefeng0707/article/details/40797085
public class HashMapInfiniteLoop {
	
	private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2,0.75f);
	public static void main(String[] args) {
		map.put(5, 55);
		
		new Thread("Thread1") {
			public void run() {
				map.put(7, 77);
				System.out.println(map);
			};
		}.start();
		new Thread("Thread2") {
			public void run() {
				map.put(3, 33);
				System.out.println(map);
			};
		}.start();
		
	}

}