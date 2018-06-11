package 集合;

import java.util.Iterator;
import java.util.Map;


/**
 * 通过程序证明hashMap是非线程安全的。就是在遍历的同时不能改变HashMap的结构
 *
 * @author weijin
 *
 */
public class MapwithThread {

	public HashMap hashMap;
	
	
	
	public static void main(String[]args){
		HashMap hashMap = new HashMap();
		for(int i=0;i<10;i++){
			hashMap.put("id"+i, i);
		}
		Thread t1= new Thread(new ThreadTestIterator(hashMap));
		Thread t2= new Thread(new ThreadTestChagnge(hashMap));
		t2.start();
		t1.start();
	}
}

class ThreadTestIterator implements Runnable{
	HashMap m ;
	public ThreadTestIterator(HashMap hashMap){
		this.m = hashMap;
	}
	public void run(){
		Iterator it = m.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			System.out.println("val="+(Integer)entry.getValue());
		}
	}
}

class ThreadTestChagnge implements Runnable{
	HashMap m ;
	public ThreadTestChagnge(HashMap hashMap){
		this.m = hashMap;
	}
	public void run(){
		Iterator it = m.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			m.put((String)entry.getKey(), (int)Math.random()*100);
		}
		m.put((int)Math.random()*100, (int)Math.random()*100);
	}
}
