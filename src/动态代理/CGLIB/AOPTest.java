package 动态代理.CGLIB;

import java.util.UUID;

public class AOPTest {
    public static void main(String[] args) {
        OrderManager order = (OrderManager) new CGLibProxy().createProxyObject(new OrderManager("aoho"));
        order.save(UUID.randomUUID(), "aoho");
    }

}
