package scheduler;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

import java.util.Date;
  
      
public class HelloJob implements Job {  
  
    /** 
     * 实现你自己的定时方法 ,至于里面写什么,您说了蒜!<br> 
     * 这里只输出 HelloWorld! 
     */  
    @Override  
    public void execute(JobExecutionContext context){
        // 输出 HelloWorld !
        System.out.println("Hello World! - " + new Date());
        System.out.println("Hello World! - " + new Date());
    }

}  
