package 多线程.safe;


/**
 * 单例模式例程二
 * 
 * @author Colin Wang
 *
 */
public class Singleton_2 {

	/*
	 * 为了避免JIT编译器对代码的指令重排序优化，可以使用volatile关键字，
	 * 通过这个关键字还可以使该变量不会在多个线程中存在副本，
	 * 变量可以看作是直接从主内存中读取，相当于实现了一个轻量级的锁。
	 */
	private volatile static Singleton_2 instance = null;

	private Singleton_2() {
	}

	public static Singleton_2 getInstacne() {
		if (instance == null) {
			synchronized (Singleton_2.class) {
				if (instance == null) {
					instance = new Singleton_2();
				}
			}
		}
		return instance;
	}
}