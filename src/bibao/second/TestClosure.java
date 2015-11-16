package bibao.second;


public class TestClosure {  
  
    public static void main(String[] args) {  
        TeachableProgrammer tp = new TeachableProgrammer("李刚");// 该示例来源于李刚老师的疯狂讲义  
        // 直接调用TeachableProgrammer从Programmer类继承下来的work方法  
        tp.work();  
        // 表明上看是调用的Closure的work方法，实际上是通过通过work方法回调TeachableProgrammer的teach方法  
        tp.getCallbackReference().work();  
    }  
  
}  