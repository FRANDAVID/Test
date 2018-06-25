package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
	//需要代理的目标对象
    private Object targetObject;
    
    public Object createProxyInstance(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(this.targetObject.getClass().getClassLoader(),
                this.targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    	//被代理对象
        OrderServiceImpl bean = (OrderServiceImpl) this.targetObject;
        Object result = null;
        //切面逻辑（advise），此处是在目标类代码执行之前
        System.out.println("---before invoke----");
        if (bean.getUser() != null) {
            result = method.invoke(targetObject, args);
        }
        System.out.println("---after invoke----");
        return result;
    }

	//...

}

