package base.agent.staticproxy;

/**
 * 静态代理测试类
 * @author zhangluping on 2018/8/21.
 */
public class TestStaticUserDaoProxy {
    public static void main(String[] args){
        UserDao target = new UserDao();
        //静态代理
        StaticUserDaoProxy staticUserDaoProxy = new StaticUserDaoProxy(target);
        staticUserDaoProxy.save();
    }
}
