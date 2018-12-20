package base.io.aio.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 作为handler接收客户端连接
 *
 * @author zhangluping on 2018/8/22.
 */
public class AIOAcceptHandler implements CompletionHandler<AsynchronousSocketChannel, AIOAsyncServerHandler> {
    @Override
    public void completed(AsynchronousSocketChannel channel, AIOAsyncServerHandler serverHandler) {
        //继续接受其他客户端的请求
        AIOServer.clientCount++;
        System.out.println("连接的客户端数：" + AIOServer.clientCount);
        serverHandler.channel.accept(serverHandler, this);
        //创建新的Buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //异步读  第三个参数为接收消息回调的业务Handler
        channel.read(buffer, buffer, new AIOReadHandler(channel));
    }

    @Override
    public void failed(Throwable exc, AIOAsyncServerHandler serverHandler) {
        exc.printStackTrace();
        serverHandler.latch.countDown();
    }
}
