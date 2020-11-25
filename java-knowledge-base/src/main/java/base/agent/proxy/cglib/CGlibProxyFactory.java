package base.agent.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangluping on 2018/8/21.
 */
public class CGlibProxyFactory implements MethodInterceptor {

    /**
     * 维护目标对象
     */
    private Object target;

    public CGlibProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象创建一个代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        //1.工具类
        net.sf.cglib.proxy.Enhancer enhancer = new net.sf.cglib.proxy.Enhancer();
        //2.设置父类,target为被代理的类
        enhancer.setSuperclass(target.getClass());
        //3.设置回调函数
        enhancer.setCallback(this);
        //4.创建子类(代理对象)
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("before CGlibProxyFactory...");
        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("after CGlibProxyFactory...");
        return returnValue;
    }
}
