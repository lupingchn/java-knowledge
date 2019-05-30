package concurrent.java.blockqueue;

import java.util.concurrent.BlockingQueue;

/**
 * @author root on 2019/5/29.
 */
public class Producer implements Runnable {

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            queue.put("1");
            Thread.sleep(1000);
            queue.put("2");
            Thread.sleep(1000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
