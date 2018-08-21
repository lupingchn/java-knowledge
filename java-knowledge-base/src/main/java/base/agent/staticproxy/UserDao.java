package base.agent.staticproxy;

/**
 *
 * @author zhangluping on 2018/8/21.
 */
public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("----UserDao 输出!----");
    }
}
