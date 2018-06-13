package thread.Jstack用法;

/**
 * Created by Rain on 16/2/19.
 */
public class MyThread implements Runnable{

    private String name;
    public MyThread(String name){
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
       for(int i=0;i<1000000;i++){
           Thread t = new Thread(new MyThread("thead=>"+i));
           t.start();
       }
    }
}
