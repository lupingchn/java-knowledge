package concurrent.java.blockqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author root on 2019/5/29.
 */
public class Consumer implements Runnable {
    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
