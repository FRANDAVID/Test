package desigonModel;


//并发模式下 传统的单例模式会失效
public class SingletonTest  
{  
    private static SingletonTest singletonTest = null;  
  
    private SingletonTest()  
    {  
    }  
  
    public static SingletonTest getInstance()  
    {  
        if (null == singletonTest)  
        {  
            try  
            {  
                Thread.sleep((long) (Math.random() * 4000));  
            } catch (InterruptedException e)  
            {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
            singletonTest = new SingletonTest();  
        }  
  
        return singletonTest;  
    }  
    //这个方法可以弥补上面那个方法在并发
    public static SingletonTest getInstanceWithBlock()  
    {  
        synchronized (SingletonTest.class)  
        {  
            if (null == singletonTest)  
            {  
  
                singletonTest = new SingletonTest();  
  
            }  
        }  
  
        return singletonTest;  
    }  
  
    public static void main(String[] args)  
    {  
        // 打印出两个对象  
        new ThreadTest().start();  
        new ThreadTest().start();  
    }  
}  
  
class ThreadTest extends Thread  
{  
    @Override  
    public void run()  
    {  
        System.out.println(SingletonTest.getInstanceWithBlock());  
    }  
}  