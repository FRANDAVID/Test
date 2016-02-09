package junitTest;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
  
/** 
 * @author bulargy.j.bai 
 * @mail bulargy@gmail.com 
 * @创建时间：Mar 11, 2008 
 * @描述： 
 * url:http://blog.csdn.net/lnara/article/details/8591182
 */  
@RunWith(Parameterized.class)  
public class MathTest {  
    int faciend;  
    int multiplicator;  
    int result;  
  
    public MathTest(int faciend, int multiplicator, int result) {  
         this.faciend = faciend;  
         this.multiplicator = multiplicator;  
         this.result = result;  
    }  
  
    @BeforeClass  
    public static void setUpBeforeClass() throws Exception {  
    }  
  
    @AfterClass  
    public static void tearDownAfterClass() throws Exception {  
    }  
  
    @Test(expected=ArithmeticException.class)  
    public void testDivide() {  
        assertEquals(3,Math.divide(9,3));  
        assertEquals(3,Math.divide(10,3));  
        Math.divide(10,0);//除数不能为0，会抛出异常  
  
    }  
  
//    @Ignore("忽略乘法测试")
    @Test  
    public void testMultiple() {  
        assertEquals(result,Math.multiple(faciend,multiplicator));
        assertEquals(2,23);
    }  
      
    @Parameters  
    public static Collection multipleValues() {  
     return Arrays.asList(new Object[][] {  
        {3, 2, 6 },  
        {4, 3, 12 },  
        {21, 5, 105 },  
        {11, 22, 242 },  
        {8, 9, 72 }});  
    }
    @Test(timeout = 10000)
    public void testTime() throws InterruptedException {
        Thread.currentThread().sleep(100);
    }

  
}  