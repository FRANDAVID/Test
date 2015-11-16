package KMP.my;

public class MyKmp {
	
	/**
	 * 返回一个next数组
	 */
	public static int[] getNext(String p){
		int []next = new int[p.length()];
		char [] P = p.toCharArray();
		int j,k,lenP ;
		j = 0;k=-1;lenP = p.length();
		
		next[0]=-1;
		while(j<lenP-1){
			if(k==-1||P[j]==P[k]){
				next[++j]=++k;
			}else{
				k = next[k];
			}
			j++;
		}
		return next;
	}
	/**
	 * 判断
	 * @param t
	 * @param next
	 * @return
	 */
	public static int kmp(String t,String p,int[]next){
		char[] T = t.toCharArray();
		char[] P = p.toCharArray();
		int pos = T.length-P.length;
		int i=0;int j=0;
		while(i<pos&&j<P.length){
			if(j==-1||T[i]==P[j]){
				i++;
				j++;
			}else{
				j=next[j];
			}
		}
		if(j==P.length){
			return i-P.length;
		}else
		{
			return -1;
		}
	}
	
	public static void print(int[]next){
		System.out.println("next 数组：");
		for(int i=0;i<next.length;i++){
			System.out.print(next[i]);
		}
		System.out.println();
	}

	public static void main(String[]args){
		String t = "abacabcaabcac";
		String p = "bcaa";
		int []next = getNext(p);
		print(next);
		int match = kmp(t,p,next);
		System.out.println(match);
	}
}
