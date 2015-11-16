package singleton;

public class BadSingleton {

	private static BadSingleton bs;
	private BadSingleton(){}
	public static BadSingleton getInstance(){
		if(bs==null){
			bs = new BadSingleton();
		}
		return bs;
	}
}
