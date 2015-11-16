package JvmToolTest;

import java.util.ArrayList;
import java.util.List;

/** 
 * 内存泄露测试 
 * @author crane.ding 
 * http://crane-ding.iteye.com/blog/715450
 * 使用JDK工具检查运行系统是否存在内存泄露
 */  
public class MemoryLeakDemo {  
  
    static List<int[]> cache = new ArrayList<int[]>();  
      
    public static void main(String[] args) throws InterruptedException {  
        Thread.currentThread().setName("Memory Leak Thread");  
          
        do {  
            cache.add(new int[1024 * 50]);// 50Kb  
              
            Thread.sleep(500);  
        } while(true);  
    }  
  
}  