package bibao.second;

  
public class TeachableProgrammer extends Programmer {  
  
    public TeachableProgrammer() {  
        super();  
    }  
  
    public TeachableProgrammer(String name) {  
        super(name);  
    }  
  
    // 教学工作任然由TeachableProgrammer定义  
    private void teach() {  
        System.out.println(getName() + "正在讲课");  
    }  
  
    private class Closure implements Teachable {  
  
        @Override  
        public void work() {  
            // 非静态内部类实现Teachable的work方法，作用仅仅是向客户类提供一个回调外部类的途径  
            teach();  
        }  
    }  
  
    // 返回一个非静态内部类的引用,允许外部类通过该引用来回调外部类的方法  
    public Teachable getCallbackReference() {  
        return new Closure();  
    }  
}  
