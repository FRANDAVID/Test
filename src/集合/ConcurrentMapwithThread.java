package 集合;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 通过程序证明hashMap是非线程安全的。就是在遍历的同时不能改变HashMap的结构
 *
 * @author weijin
 *
 */
public class ConcurrentMapwithThread {

	public ConcurrentHashMap hashMap;
	
	
	
	public static void main(String[]args){
		ConcurrentHashMap hashMap = new ConcurrentHashMap();
		for(int i=0;i<10;i++){
			hashMap.put("id"+i, i);
		}
		Thread t1= new Thread(new CThreadTestIterator(hashMap));
		Thread t2= new Thread(new CThreadTestChagnge(hashMap));
		t2.start();
		t1.start();
	}
}

class CThreadTestIterator implements Runnable{
	ConcurrentHashMap m ;
	public CThreadTestIterator(ConcurrentHashMap hashMap){
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

class CThreadTestChagnge implements Runnable{
	ConcurrentHashMap m ;
	public CThreadTestChagnge(ConcurrentHashMap hashMap){
		this.m = hashMap;
	}
	public void run(){
		Iterator it = m.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry entry = (Map.Entry)it.next();
			m.put((String)entry.getKey(), (int)Math.random()*100);
		}
		m.put((int)Math.random()*100, (int)Math.random()*10000+1);
	}
}
