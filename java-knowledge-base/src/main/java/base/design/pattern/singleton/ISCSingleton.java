package base.design.pattern.singleton;

/**
 * 静态内部类模式
 *
 * @author root on 2018/12/20.
 */
public class ISCSingleton {
    private ISCSingleton() {
    }

    private static class ISCSingletonHoler {
        private static ISCSingleton INSTANCE = new ISCSingleton();
    }

    public static ISCSingleton getInstance() {
        return ISCSingletonHoler.INSTANCE;
    }
}
