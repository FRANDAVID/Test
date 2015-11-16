package stringADT;

import java.util.Stack;
import java.util.StringTokenizer;

import leetcode.StringtoInteger;

public class RevotWord {

	public static void main(String[]args){
		String str = "I'm very happy";
		RevotWord.revortWord(str);
		revortWordWithStack( str);
		userStringTokenizer(str," ");
	}
	public static String revortWord(String str){
		if(null==str){
			return "";
		}
		String[] temp = str.split(" ");
		for(int i=temp.length-1;i>=0;i--){
			System.out.print(temp[i]+" ");
		}
		System.out.println();
		return "";
	}
	
	public static String revortWordWithStack(String str)
	{
		
		Stack s = new Stack();
		String[] temp = str.split(" ");
		for(int i=0;i<temp.length;i++){
			s.push(temp[i]);
		}
		while(s.empty()==false){
			System.out.print(s.pop()+" ");
		}
		return "";
	}
	
	public static String userStringTokenizer(String str ,String token)
	{
		StringTokenizer st=new StringTokenizer(str,token);
		while(st.hasMoreElements()){
			System.out.print(st.nextToken()+" ");
		}
		return "";
	}
}
