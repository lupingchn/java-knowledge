package base.lambda;

/**
 * @author:zhangluping
 * @description:
 * @date:2019/6/3 20:23
 */
public class TestLambda {
    /**
     * lambda实现
     */
    private static void runThreadUseLambda() {
        new Thread(() -> System.out.println("我是lambda实现的线程")).start();
    }

    /**
     * 内部类实现
     */
    private static void runThreadUseInnerClass() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("内部类实现的线程");
            }
        }).start();
    }

    public static void main(String[] args) {
        TestLambda.runThreadUseLambda();
        TestLambda.runThreadUseInnerClass();
    }
}
