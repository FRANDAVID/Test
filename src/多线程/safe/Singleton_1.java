package 多线程.safe;


/**
 * 单例模式例程一
 * 
 * @author Colin Wang
 *
 */
public class Singleton_1 {

	private static Singleton_1 instance = null;

	private Singleton_1() {
	}

	public static Singleton_1 getInstacne() {
		/*
		 * 这种实现进行了两次instance==null的判断，这便是单例模式的双检锁。
		 * 第一次检查是说如果对象实例已经被创建了，则直接返回，不需要再进入同步代码。
		 * 否则就开始同步线程，进入临界区后，进行的第二次检查是说：
		 * 如果被同步的线程有一个创建了对象实例， 其它的线程就不必再创建实例了。
		 */
		if (instance == null) {
			synchronized (Singleton_1.class) {
				if (instance == null) {
					/*
					 * 仍然存在的问题：下面这句代码并不是一个原子操作，JVM在执行这行代码时，会分解成如下的操作：
					 * 1.给instance分配内存，在栈中分配并初始化为null
					 * 2.调用Singleton_1的构造函数，生成对象实例，在堆中分配 
					 * 3.把instance指向在堆中分配的对象
					 * 由于指令重排序优化，执行顺序可能会变成1，3，2，
					 * 那么当一个线程执行完1，3之后，被另一个线程抢占，
					 * 这时instance已经不是null了，就会直接返回。
					 * 然而2还没有执行过，也就是说这个对象实例还没有初始化过。
					 */
					instance = new Singleton_1();
				}
			}
		}
		return instance;
	}
}