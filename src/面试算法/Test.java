package 面试算法;

import java.util.ArrayList;
//http://www.cnblogs.com/javazhiyin/p/java_zhiyin.html?hmsr=toutiao.io&utm_medium=toutiao.io&utm_source=toutiao.io
public class Test {
 
   public void testHeap(){  
       for(;;){  
             ArrayList list = new ArrayList (2000);
         }  
   }  
   int num=1;  
   public void testStack(){  
       num++;  
       this.testStack();  
    }  
     
   public static void main(String[] args){  
       Test  t  = new Test ();  
       t.testHeap();  
       t.testStack();     
   }  
}