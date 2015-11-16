package ADTcase;

import java.util.LinkedList;
import java.util.List;


public class LinkJosephus {

	public LinkJosephus(int number,int start,int distance){
		List<String> list=new LinkedList<String>();//直接利用java中自带的LinkedList
		for(int i=0;i<number;i++){
			list.add((char)('A'+i)+"");
		}
		System.out.print("约瑟夫环("+number+","+start+","+distance+"),");
		System.out.println(list.toString());
		int i=start;
		while(list.size()>1){
			i=(i+distance-1)%list.size();
			System.out.print("删除的元素："+list.remove(i).toString()+",");
			System.out.println(list.toString());
		}
		System.out.println("被赦免的罪犯是："+list.get(0).toString());
	}
	
	public static void main(String[] args) {
		new LinkJosephus(5,0,2);
	}

}
