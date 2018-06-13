package thread.thread;
public class DrawThread extends Thread {  
/** 
     * @author Cruise 
     * @param args 
     */  
    private Account account;  
    private double drawAmount;  
  
    public DrawThread(String name, Account account, double drawAmount) {  
        super(name);  
        this.account = account;  
        this.drawAmount = drawAmount;  
    }  
      
    public void run(){  
        for(int i=0; i<100; i++){  
//          System.out.println("???" + Thread.currentThread().getName()+"???????");  
            account.draw(drawAmount);  
        }  
    }  
}  