package network.rpc2;  
  
public class HelloServiceImpl implements HelloService{  
    public String hello(String name) {  
        return "Hello " + name;  
    }  
  
}  