package thread.cyclicbarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
/*
 * 继续，还是这五个人（这五个人真无聊..），这次没裁判。规定五个人只要都跑到终点了，大家可以喝啤酒。
 * 但是，只要有一个人没到终点，就不能喝。
 *  这里也没有要求大家要同时起跑(当然也可以，加latch)。
    *
 */
public class Beer {

	public static void main(String[] args) {
		final int count = 5;
		final CyclicBarrier barrier = new CyclicBarrier(count, new Runnable() {
			@Override
			public void run() {
				System.out.println("drink beer!");
			}
		});

		// they do not have to start at the same time...
		for (int i = 0; i < count; i++) {
			new Thread(new Worker(i, barrier)).start();
		}
	}

}

class Worker implements Runnable {
	final int id;
	final CyclicBarrier barrier;

	public Worker(final int id, final CyclicBarrier barrier) {
		this.id = id;
		this.barrier = barrier;
	}

	@Override
	public void run() {
		try {
			System.out.println(this.id + "starts to run !");
			Thread.sleep((long) (Math.random() * 10000));
			System.out.println(this.id + "arrived !");
			this.barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
}
