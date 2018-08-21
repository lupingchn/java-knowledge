package base.agent.staticproxy;

/**
 * 静态代理类，继承接口，实现接口的方法
 * @author zhangluping on 2018/8/21.
 */
public class StaticUserDaoProxy implements IUserDao {
    /**
     * 接收保存目标对象
     */
    private IUserDao target;

    public StaticUserDaoProxy(IUserDao target) {
        this.target = target;
    }

    @Override
    public void save() {
        System.out.println("before StaticUserDaoProxy...");
        target.save();//执行目标对象的方法
        System.out.println("after StaticUserDaoProxy...");
    }
}
