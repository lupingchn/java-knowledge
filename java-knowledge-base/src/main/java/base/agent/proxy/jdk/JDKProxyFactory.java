package base.agent.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangluping on 2018/8/21.
 */
public class JDKProxyFactory {

    /**
     * 维护一个目标对象
     */
    private Object target;

    public JDKProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * 给目标对象生成代理对象
     */
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before JDKProxyFactory");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("after JDKProxyFactory");
                        return returnValue;
                    }
                }
        );
    }
}
