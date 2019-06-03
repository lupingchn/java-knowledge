package base.innerclass;

/**
 * @author:zhangluping
 * @description:
 * @date:2019/6/3 9:24
 */
public class InnerClassDemo{
    private int length =0;

    private class InnerClass implements ILog {
        @Override
        public void write(String message) {
            length = message.length();
            System.out.println("DemoClass.InnerClass:" + length);
        }
    }

    public ILog logger() {
        return new InnerClass();
    }


    public ILog loggerAnonymity() {
        return new ILog() {
            @Override
            public void write(String message) {
                length = message.length();
                System.out.println("DemoClass.InnerClass:" + length);
            }
        };
    }

    public ILog loggerLambda() {
        return message -> {
            length = message.length();
            System.out.println("DemoClass.InnerClass:" + length);
        };
    }


    public static void main(String[] args){
        InnerClassDemo demoClass = new InnerClassDemo();
        demoClass.logger().write("123");

        //new
        InnerClassDemo dc = new InnerClassDemo();
        ILog ic = dc.loggerAnonymity();
        ic.write("12345");

        dc.loggerLambda().write("123456");
    }
}
