package base.agent.test;

import base.agent.cglibproxy.CGlibProxyFactory;
import base.agent.jdkproxy.JDKProxyFactory;
import base.agent.origin.IUserDao;
import base.agent.origin.UserDao;
import base.agent.origin.UserDaoWithoutInterface;
import base.agent.staticproxy.StaticUserDaoProxy;
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
        IUserDao iTarget = (IUserDao) jdkProxyFactory.getProxyInstance();
        iTarget.save();
    }

    /**
     * 测试JDK静态代理实现
     */
    @Test
    public void testJdkProxyFactoryWithoutInterface() {
        //jdk动态代理
        JDKProxyFactory jdkProxyFactory = new JDKProxyFactory(targetWithoutInterface);
        // 注意,只能返回接口而不是具体实现类，否则报如下错误
        UserDaoWithoutInterface iTarget = (UserDaoWithoutInterface) jdkProxyFactory.getProxyInstance();
        iTarget.save();
    }

    @Test
    public void testCGlibProxyFactoryWithoutInterface(){
        CGlibProxyFactory cGlibProxyFactory = new CGlibProxyFactory(targetWithoutInterface);
        UserDaoWithoutInterface dao = (UserDaoWithoutInterface) cGlibProxyFactory.getProxyInstance();
        dao.save();
    }

    @Test
    public void testCGlibProxyFactoryWithInterface(){
        CGlibProxyFactory cGlibProxyFactory = new CGlibProxyFactory(targetWithInterface);
        UserDao dao = (UserDao) cGlibProxyFactory.getProxyInstance();
        dao.save();
    }

}
