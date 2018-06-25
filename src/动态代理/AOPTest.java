package 动态代理;

import java.util.UUID;

public class AOPTest {
    public static void main(String[] args) {
        JDKProxy factory = new JDKProxy();
        //Proxy为InvocationHandler实现类动态创建一个符合某一接口的代理实例  
        OrderService orderService = (OrderService) factory.createProxyInstance(new OrderServiceImpl("aoho"));
		//由动态生成的代理对象来orderService 代理执行程序
        orderService.save(UUID.randomUUID(), "aoho");
    }

}
