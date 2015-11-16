package scheduler;
import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 这外例子说明了如何开始和关闭一个 Quartz scheduler
 * 及如何运行一个任务 
 */
public class SimpleExample {

	public void run() throws Exception {
		System.out.println("------- 初始化 获得 Scheduler 对象 -------------");

		// 获得 Scheduler 对象 
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();

		// 获取下一分钟,即当前时间的下一分钟
		Date runTime = evenMinuteDate(new Date());

		// 定义一个 job 对象并绑定我们写的  HelloJob 类 
		// 真正执行的任务并不是Job接口的实例，而是用反射的方式实例化的一个JobDetail实例  
		JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

		// 定义一个触发器，startAt方法定义了任务应当开始的时间 .即下一个整数分钟执行
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

		// 将任务和Trigger放入scheduler  
		sched.scheduleJob(job, trigger);
		System.out.println(job.getKey() + " 将在: " + runTime +" 运行");

		// 启动
		sched.start();
		System.out.println("------- 任务调度已经启动 -----------------");
		System.out.println("------- 等待 65 秒,保证下一个整数分钟出现 ... ---");
		try {
			// 等待65秒，保证下一个整数分钟出现，这里注意，如果主线程停止，任务是不会执行的  
			Thread.sleep(65L * 1000L);
		} catch (Exception e) { }

		// 关闭 scheduler
		sched.shutdown(true);
		System.out.println("------- 调度已关闭 ---------------------");
	}
	
	public static void main(String[] args) throws Exception {
		SimpleExample example = new SimpleExample();
		example.run();

	}

}