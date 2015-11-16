package KMP;


public class KMP2 {
	/**
	 * 
	 *  获取模式串在主串中出现的位置
	 * @param mStr 
	 * @param pStr
	 * @param pos 如果模式串在主串中存在，返回模式串在主串中出现的位置，否则返回-1
	 * @return
	 */
	public int indexKMP(String mStr,String pStr,int pos)
	{
		int i=pos,j=0;
		int pLen = pStr.length();//模式字符串长度
		int mLen = mStr.length();//主字符串长度
		char[] mChar = mStr.toCharArray(); //主字符串字符数组
		char[] pChar = new char[pLen+1];//模式字符串字符数组从第二个元素位置开始存放
		System.arraycopy(pStr.toCharArray(), 0, pChar, 1, pLen);//拷贝
		int next[] = getNextVal(pStr);
		while(i<mLen&&j<=pLen)
		{
			if(j==0||mChar[i]==pChar[j])
			{
				i++;
				j++;
			}else{
				j = next[j];//匹配失败，回溯
			}
		}
		if(j>=pLen)//主字符串中存在模式模式字符串
		{
			return i-j; //返回模式字符串在主字符串中出现的位置
		}
		
		return -1;//主字符串中不存在
	}
	/**
	 *  未经优化next数组
	 * @param pStr
	 * @return
	 */
	private int[] getNext(String pStr)
	{
		int i=1,j=0,len = pStr.length();
		char[] pChar = new char[len+1];//该字符数组用来存放pStr中的每个字符，当从pChar[1]位置开始存放
		System.arraycopy(pStr.toCharArray(), 0, pChar, 1, len);//拷贝
		int[] next = new int[len+1];//定义next数组用于存放每个字符在匹配失败时，需要回溯的位置
		while(i<len)//字符数组变量完毕
		{
			if(j==0||pChar[i] == pChar[j])
			{
				i++;
				j++;
				next[i] = j;  //设置回溯值
			}else{
				j = next[j];//从该位置回溯
			}
		}
		return next;
	}
	/**
	 *  优化后的next数组
	 * @param pStr
	 * @return
	 */
	private int[] getNextVal(String pStr)
	{
		int i=1,j=0,len = pStr.length();
		char[] pChar = new char[len+1];//该字符数组用来存放pStr中的每个字符，当从pChar[1]位置开始存放
		System.arraycopy(pStr.toCharArray(), 0, pChar, 1, len);//拷贝
		int[] next = new int[len+1];//定义next数组用于存放每个字符在匹配失败时，需要回溯的位置
		while(i<len)//字符数组变量完毕
		{
			if(j==0||pChar[i] == pChar[j])
			{
				i++;
				j++;
				if(pChar[i]!=pChar[j])
				{
					next[i] = j;  //设置回溯值
				}else{
					next[i] = next[j];//如果两个字符相等，那么将pChar[j]的回溯值复制给pChar[i]
				}
			}else{
				j = next[j];//从该位置回溯
			}
		}
		return next;
	}
	public static void printNext(int []next){
		for(int i=0;i<next.length;i++){
			System.out.print(next[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		String mStr = "ababaad";//主串
		String pStr = "abab";//模式串
		KMP2 kmp = new KMP2();
		kmp.printNext(kmp.getNext("abab"));
		kmp.printNext(kmp.getNextVal("abab"));
		System.out.println(kmp.indexKMP(mStr, pStr, 0));
	}
}