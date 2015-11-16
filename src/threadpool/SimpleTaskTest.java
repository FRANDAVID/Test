package threadpool;

/**
 * 
* @ClassName: SimpleTaskTest  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author A18ccms a18ccms_gmail_com  
* @date 2015年9月15日 下午3:13:53  
*
 */
public class SimpleTaskTest extends Task {
	@Override
	public void deal() {
		for(int i=0;i<3;i++){
			System.out.println(" "+i);
			
		}
	}
	public static void main(String[] args) throws InterruptedException {
		ThreadPoolService service = new ThreadPoolService();
		service.start();
		// 执行十次任务
		for (int i = 0; i < 10; i++) {
			service.runTask(new SimpleTaskTest());
		}
		// 睡眠1秒钟，等待所有任务执行完毕
		Thread.sleep(1000);
		service.stop();
	}
}