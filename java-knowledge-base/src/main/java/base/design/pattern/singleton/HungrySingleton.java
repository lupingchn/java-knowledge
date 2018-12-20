package base.design.pattern.singleton;

/**
 * 饿汉模式
 *
 * @author root on 2018/12/20.
 */
public class HungrySingleton {
    private static HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
