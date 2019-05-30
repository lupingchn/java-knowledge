package concurrent.java.countdownlath;

import java.util.concurrent.CountDownLatch;

/**
 * @author root on 2019/5/29.
 */
public class Decrementer implements Runnable {

    private CountDownLatch latch = null;

    public Decrementer(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("Decrementer countDown 1");

            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("Decrementer countDown 2");

            Thread.sleep(1000);
            this.latch.countDown();
            System.out.println("Decrementer countDown 3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
