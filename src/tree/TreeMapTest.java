package tree;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[]args){
		Map tm = new TreeMap();
		tm.put(1, 1111);
		tm.put(2,222);
		tm.put(0,0);
		tm.put(5,555);
		tm.put(4,444);
		Iterator it = tm.entrySet().iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
