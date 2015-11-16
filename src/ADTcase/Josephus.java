package ADTcase;


/**
 * 
 * @author zhaoliang
 * 约瑟夫问题    
 * @date 2014-11-12
 * @time 16:51
 */
public class Josephus {

	/**
	 * 
	 * @param n  一共有多少个人 报数
	 * @param start 从第几个开始报数
	 * @param step	报数的步长
	 * @return
	 */
	public int getResult(int n,int start,int step){
		int[] all=null;
		//初始化这个队列
		if(all==null){
			all=new int[n];
			for(int i=0;i<n;i++){
				all[i]=i+1;
			}
		}
		//计算出数组的开始数下标
		int startIndex=start%n-1; 
		while(all[1]!=0){
			
			for(int i=0;i<n;i++){
				System.out.print(all[i]+"-");
			}
			System.out.println();
			//计算出要删除数组的下标
			int removeIndex=(startIndex+step-1)%n;
			startIndex=removeIndex;
			//将后面的数字往前移动一个位置
			while(removeIndex<n-1){
				all[removeIndex]=all[removeIndex+1];
				removeIndex++;
			}
			//将最后一个位置的数字设置为0
			all[n-1]=0;
			//每次只删除一个
			n--;
		}
		System.out.println();
		return all[0];
	}



	/**
	 * @param args
	 * 测试
	 */
	public static void main(String[] args) {
		Josephus josephus=new Josephus();
		System.out.println(josephus.getResult(6, 9, 3));
	}

}
