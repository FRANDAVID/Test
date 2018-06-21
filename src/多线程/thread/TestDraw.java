package 多线程.thread;


public class TestDraw {  
  
    /** 
     * @author Cruise 
     * @param args 
     */  
    public static void main(String[] args) {  
        Account account = new Account("123", 0);  
        new DrawThread("取钱者", account, 800).start();  
        new DepositThread("存款者甲",account, 800).start();  
        new DepositThread("存款者乙",account, 800).start();  
  
    }  
  
}  