package singleton;
class GoodSingletonThread implements Runnable{
	public Singleton s;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		s = Singleton.getInstance();
		System.out.println("good Singleton=>"+s);
	}
}