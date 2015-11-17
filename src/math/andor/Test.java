package math.andor;

import java.text.DecimalFormat;

public class Test{
	
	public static void main(String[]args)
	{
		int a =10;
		int b =11;
		int c =2;
		int d =256;
		a = a^b;System.out.println("a="+a+",b="+b+",c="+c);
		b = b^a;System.out.println("a="+a+",b="+b+",c="+c);
		a = a^b;System.out.println("a="+a+",b="+b+",c="+c);
		c = c<<4;
		d = d>>2;
		System.out.println("a="+a+" b="+b+" c="+ c+" d="+d);
		System.out.println(2<<2);
		System.out.println(4>>2);
		float num= (float)300/1000;   
		DecimalFormat df = new DecimalFormat("0.0");//格式化小数   
		String s = df.format(num);//返回的是String类型 
		System.out.println(s);
		System.out.println(1<<31); //2*2^2
		System.out.println(2^31);
		System.out.println(4>>2);
		System.out.println(1<<30);
	}
}
