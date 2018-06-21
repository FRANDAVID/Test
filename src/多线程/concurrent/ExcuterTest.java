/**    
* @Title: ExcuterTest.java  
* @Package 多线程.concurrent
* @Description: TODO(用一句话描述该文件做什么)  
* @author weijin@baidu.com
* @date 2015年8月27日 上午11:06:05  
* @version V1.0    
*/
package 多线程.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  
 * @ClassName: ExcuterTest  
 * @Description: TODO(这里用一句话描述这个类的作用)  
 * @author A18ccms a18ccms_gmail_com  
 * @date 2015年8月27日 上午11:06:05  
 *
 *
 */
public class ExcuterTest {

    public static void main(String[]args){
         ExecutorService syncExecutor = Executors.newFixedThreadPool(2);
         System.out.println("start");
         syncExecutor.execute(new Runnable() {
             @Override
             public void run() {
                 
                 for(int i=0;i<10;i++){
                     System.out.println(Thread.currentThread().getName()+"=is="+i);
                 }
             }
         });

         syncExecutor.execute(new Runnable() {
             @Override
             public void run() {
                 for(int i=0;i<10;i++){
                     System.out.println(Thread.currentThread().getName()+"-is-"+i);
                 }             }
         });
         System.out.println("end");
    }
}
