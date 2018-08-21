package base.agent.proxy.test;

import base.agent.proxy.cglib.CGlibProxyFactory;
import base.agent.proxy.jdk.JDKProxyFactory;
import base.agent.proxy.staticagent.StaticUserDaoProxy;
import base.agent.target.IUserDao;
import base.agent.target.UserDao;
import base.agent.target.UserDaoWithoutInterface;
import org.junit.Test;

/**
 * @author zhangluping on 2018/8/21.
 */
public class TestProxyFactory {

    private UserDao targetWithInterface = new UserDao();

    private UserDaoWithoutInterface targetWithoutInterface = new UserDaoWithoutInterface();


    /**
     * 测试静态代理实现
     */
    @Test
    public void testStaticDaoProxy() {
        //静态代理
        StaticUserDaoProxy staticUserDaoProxy = new StaticUserDaoProxy(targetWithInterface);
        staticUserDaoProxy.save();
    }

    /**
     * 测试JDK静态代理实现
     */
    @Test
    public void testJdkProxyFactoryWithInterface() {
        //jdk动态代理
        JDKProxyFactory jdkProxyFactory = new JDKProxyFactory(targetWithInterface);
        // 注意,只能返回接口而不是具体实现类，否则报错，参见testJdkProxyFactoryWithoutInterface方法
        IUserDao iTarget1 = (IUserDao) jdkProxyFactory.getProxyInstance();
        System.out.println("ProxyObj = " + iTarget1.getClass().toString());
        iTarget1.save();
        IUserDao iTarget2 = (IUserDao) jdkProxyFactory.getProxyInstanceForUser();
        System.out.println("ProxyObj = " + iTarget2.getClass().toString());
        iTarget2.save();
    }

    /**
     * 测试cglib动态代理
     */
    @Test
    public void testCGlibProxyFactoryWithoutInterface() {
        CGlibProxyFactory cGlibProxyFactory = new CGlibProxyFactory(targetWithoutInterface);
        UserDaoWithoutInterface pTarget = (UserDaoWithoutInterface) cGlibProxyFactory.getProxyInstance();
        System.out.println("ProxyObj = " + pTarget.getClass().toString());
        pTarget.save();
    }

    /**
     * 测试JDK静态代理实现无接口的对象，会报错
     */
    @Test
    public void testJdkProxyFactoryWithoutInterface() {
        //jdk动态代理
        JDKProxyFactory jdkProxyFactory = new JDKProxyFactory(targetWithoutInterface);
        // 注意,只能返回接口而不是具体实现类，否则报如下错误
        UserDaoWithoutInterface pTarget = (UserDaoWithoutInterface) jdkProxyFactory.getProxyInstance();
        System.out.println("ProxyObj = " + pTarget.getClass().toString());
        pTarget.save();
    }
}
