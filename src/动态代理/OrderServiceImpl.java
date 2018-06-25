package 动态代理;

import java.util.UUID;

public class OrderServiceImpl implements OrderService {

    private String user = null;

    public OrderServiceImpl() {
    }

    public OrderServiceImpl(String user) {
        this.setUser(user);
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public void save(UUID orderId, String name) {
        System.out.println("call save()方法,save:" + name);
    }

    @Override
    public void update(UUID orderId, String name) {
        System.out.println("call update()方法");
    }

    @Override
    public String getByName(String name) {
        System.out.println("call getByName()方法");
        return "aoho";
    }
}
