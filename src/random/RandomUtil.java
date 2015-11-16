package random;

import java.text.DecimalFormat;
import java.util.Random;

public class RandomUtil {

	public static void main(String[]args){
		DecimalFormat    df   = new DecimalFormat("######0.00");   
		Random r = new Random(2);
		for(int i=0;i<10;i++){
			
			System.out.println(df.format(r.nextDouble()));
		}
	}
}
