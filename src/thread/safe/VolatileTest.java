package thread.safe;


/**
 * 发起20个线程，每个线程对race变量进行10000次自增操作，如果代码能够正确并发，
 * 则最终race的结果应为200000，但实际的运行结果却小于200000。
 * 
 * @author Colin Wang
 * 当一个变量被定义为volatile之后，就可以保证此变量对所有线程的可见性，即当一个线程修改了此变量的值的时候，
 * 变量新的值对于其他线程来说是可以立即得知的。可以理解成：对volatile变量所有的写操作都能立刻被其他线程得知。
 * 但是这并不代表基于volatile变量的运算在并发下是安全的，
 * 因为volatile只能保证内存可见性，却没有保证对变量操作的原子性。比如下面的代码：
 * 
 * 这便是因为race++操作不是一个原子操作，导致一些线程对变量race的修改丢失。若要使用volatale变量，
 * 一般要符合以下两种场景：

变量的运算结果并不依赖于变量的当前值，或能够保证只有单一的线程修改变量的值。
变量不需要与其他的状态变量共同参与不变约束。
 *
 */
public class VolatileTest {
	public static volatile int race = 0;

	public static void increase() {
		race++;
	}

	private static final int THREADS_COUNT = 20;

	public static void main(String[] args) {
		Thread[] threads = new Thread[THREADS_COUNT];

		for (int i = 0; i < THREADS_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						increase();
					}
				}
			});
			threads[i].start();
		}

		while (Thread.activeCount() > 1)
			Thread.yield();

		System.out.println(race);
	}
}