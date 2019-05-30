package concurrent.java.countdownlath;

import java.util.concurrent.CountDownLatch;

/**
 * @author root on 2019/5/29.
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);
        Decrementer decrementer = new Decrementer(latch);

        new Thread(waiter).start();
        new Thread(decrementer).start();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
