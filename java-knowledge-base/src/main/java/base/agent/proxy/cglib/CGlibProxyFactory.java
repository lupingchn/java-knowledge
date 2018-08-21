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
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
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
