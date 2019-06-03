package concurrent.java.exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author:zhangluping
 * @description:
 * @date:2019/5/30 9:28
 */
public class ExchangerDemo {
    public static class ExchangerRunnable implements Runnable{

        Exchanger exchanger = null;
        Object    object    = null;

        ExchangerRunnable(Exchanger exchanger, Object object) {
            this.exchanger = exchanger;
            this.object = object;
        }

        @Override
        public void run() {
            try {
                Object previous = this.object;
//                if(Thread.currentThread().getId() % 2 == 0) {
                    this.object = this.exchanger.exchange(this.object);
//                }
                System.out.println(
                        Thread.currentThread().getName() +
                                " exchanged " + previous + " for " + this.object
                );
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        ExchangerDemo.ExchangerRunnable exchangerRunnable1 =
                new ExchangerDemo.ExchangerRunnable(exchanger, "A");

        ExchangerDemo.ExchangerRunnable exchangerRunnable2 =
                new ExchangerDemo.ExchangerRunnable(exchanger, "B");

        ExchangerDemo.ExchangerRunnable exchangerRunnable3 =
                new ExchangerDemo.ExchangerRunnable(exchanger, "C");

        ExchangerDemo.ExchangerRunnable exchangerRunnable4 =
                new ExchangerDemo.ExchangerRunnable(exchanger, "D");

        new Thread(exchangerRunnable1).start();
        new Thread(exchangerRunnable2).start();
        new Thread(exchangerRunnable3).start();
        new Thread(exchangerRunnable4).start();
    }
}
