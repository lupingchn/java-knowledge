package base.io.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * BIO服务端源码__伪异步I/O
 * @author zhangluping on 2018/8/22.
 */
public class BIOServerBetter {
    /**
     * 默认的端口号
     */
    private static int DEFAULT_PORT = 12345;
    /**
     * 单例的ServerSocket
     */
    private static ServerSocket server;
    /**
     * 线程池 懒汉式的单例
     */
    private static ExecutorService executorService = Executors.newFixedThreadPool(60);

    /**
     * 根据传入参数设置监听端口，如果没有参数调用以下方法并使用默认值
     * @throws IOException
     */
    public static void start() throws IOException {
        //使用默认值
        start(DEFAULT_PORT);
    }

    public synchronized static void start(int port) throws IOException {
        if (server != null) {
            return;
        }
        try {
            //通过构造函数创建ServerSocket
            //如果端口合法且空闲，服务端就监听成功
            server = new ServerSocket(port);
            System.out.println("服务器已启动，端口号：" + port);
            //通过无线循环监听客户端连接
            //如果没有客户端接入，将阻塞在accept操作上。
            while (true) {
                Socket socket = server.accept();
                //当有新的客户端接入时，会执行下面的代码
                //然后创建一个新的线程处理这条Socket链路
                executorService.execute(new BIOServerHandler(socket));
            }
        } finally {
            //一些必要的清理工作
            if (server != null) {
                System.out.println("服务器已关闭。");
                server.close();
                server = null;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //运行服务器
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BIOServerBetter.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
