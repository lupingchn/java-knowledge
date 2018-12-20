package base.design.pattern.singleton;

/**
 * 双重检查锁懒汉模式(Double Check Lock)
 *
 * @author root on 2018/12/20.
 */
public class DCLSingleton {

    /**
     * volatile：JVM存在指令重排功能，为防止对象new的过程中并发导致异常问题，具体见后
     */
    private volatile static DCLSingleton INSTANCE = null;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        // 避免非必要加锁引发的单线程性能降低问题
        if (INSTANCE == null) {
            synchronized (DCLSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DCLSingleton();
                }
            }
        }
        return INSTANCE;
    }
}
