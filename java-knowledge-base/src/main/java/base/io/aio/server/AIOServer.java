package base.io.aio.server;

/**
 * AIO服务端
 *
 * @author zhangluping on 2018/8/22.
 */
public class AIOServer {
    private static int DEFAULT_PORT = 12345;
    private static AIOAsyncServerHandler serverHandle;
    public volatile static long clientCount = 0;

    public static void start() {
        start(DEFAULT_PORT);
    }

    public static synchronized void start(int port) {
        if (serverHandle != null)
            return;
        serverHandle = new AIOAsyncServerHandler(port);
        new Thread(serverHandle, "Server").start();
    }

    public static void main(String[] args) {
        AIOServer.start();
    }
}
