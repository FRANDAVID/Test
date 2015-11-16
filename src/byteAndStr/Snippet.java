package byteAndStr;

import java.io.UnsupportedEncodingException;

public class Snippet {
	public static void main(String[] args) throws UnsupportedEncodingException {

		byte[] byBuffer = new byte[20];
		String strRead = new String(byBuffer);
		strRead = String.copyValueOf(strRead.toCharArray(), 0, byBuffer.length);
		System.out.println(strRead);
		
		byte[] byBuffer2 = new byte[200];
		String strInput="abcdefg";
		byBuffer2= strInput.getBytes();
		
		System.out.println(byBuffer2);
		
		
		byte[] byBuffer3 = new byte[200];
		String strInput3="我是字符串";
		byBuffer3= strInput3.getBytes("utf-8");
		
		System.out.println(new String(byBuffer3,"utf-8"));
		System.out.println("www.baidu.com".getBytes().length);
		System.out.println("2222".getBytes().length);
    	String smoke_L1="{\"sn\":\"AISN145010010022\",\"pm25\":\"10\",\"voc\":\"0.01\",\"smoke\":\"4000\",\"noise\":\"0\",\"temp\":\"0\",\"humidity\":\"0\"}";
    	System.out.println(smoke_L1.getBytes().length);

	}
}
