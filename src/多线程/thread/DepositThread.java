package thread.thread;
public class DepositThread extends Thread {  
  
    private Account account;  
    private double depositAmount;  
  
    public DepositThread(String name, Account account, double depositAmount) {  
        super(name);  
        this.account = account;  
        this.depositAmount = depositAmount;  
    }  
      
    public void run(){  
        for(int i=0; i<100; i++){  
//          System.out.println("???" + Thread.currentThread().getName()+"???????");  
            account.deposit(depositAmount);  
        }  
    }  
}  