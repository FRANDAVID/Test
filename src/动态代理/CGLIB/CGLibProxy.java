package 动态代理.CGLIB;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {
    	// CGLib需要代理的目标对象
    	private Object targetObject;

       public Object createProxyObject(Object obj) {
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        //回调方法的参数为代理类对象CglibProxy，最后增强目标类调用的是代理类对象CglibProxy中的intercept方法 
        enhancer.setCallback(this);
        //增强后的目标类
        Object proxyObj = enhancer.create();
        // 返回代理对象
        return proxyObj;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        Object obj = null;
        //切面逻辑（advise），此处是在目标类代码执行之前
        System.out.println("---before intercept----");
        obj = method.invoke(targetObject, args);
        System.out.println("---after intercept----");
        return obj;
    }
}

作者：aoho
链接：https://juejin.im/post/5a3284a75188252970793195
来源：掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。