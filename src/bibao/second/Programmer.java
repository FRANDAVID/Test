package bibao.second;

  
public class Programmer {  
    private String name;  
  
    public Programmer() {  
        super();  
    }  
  
    public Programmer(String name) {  
        super();  
        this.name = name;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public void work() {  
        System.out.println(name + "正在编程");  
    }  
} 