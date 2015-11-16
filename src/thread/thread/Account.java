package thread.thread;


public class Account {

	/**
	 * @author Cruise
	 * @param args
	 */
	private String accountNo;
	//标识账户是否还有存款的
	private boolean flag = false;
	private double balance;

	public Account(){}
	public Account(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}

	public double getBalance(){
		return balance;
	}
	public synchronized void draw(double drawAmount) {
		try {
			if (!flag) {  //如果账户没钱
				wait();  //阻塞当前的方法，并释放同步锁（这里就是this，也就是调用此方法的对象）
			} else {
				System.out.println("线程：" + Thread.currentThread().getName()
						+ "取款" + drawAmount);
				balance -= drawAmount;
				System.out.println("账户余额：" + balance);
				flag = false;
				notifyAll();  //唤醒等待此同步锁的所有线程
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void deposit(double depositAmount) {

		try{
			if(flag){ //如果账户有存入的钱
				wait();
			}else{
				System.out.println("线程："+ Thread.currentThread().getName()+"存款"+depositAmount);
				balance += depositAmount;
				System.out.println("账户余额：" + balance);
				flag = true;
				notifyAll();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
