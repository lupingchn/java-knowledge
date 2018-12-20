package base.design.pattern.singleton;

/**
 * 懒汉模式（简单）
 *
 * @author root on 2018/12/20.
 */
public class SimpleLazySingleton {
    private static SimpleLazySingleton INSTANCE = null;

    private SimpleLazySingleton() {
    }

    public static SimpleLazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SimpleLazySingleton();
        }
        return INSTANCE;
    }
}
