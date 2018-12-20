package base.io.aio.client;

import base.io.aio.server.AIOReadHandler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author zhangluping on 2018/8/22.
 */
public class AIOWriteHandler implements CompletionHandler<Integer, ByteBuffer> {

    /**
     * 用于发送半包消息和发送应答
     */
    private AsynchronousSocketChannel channel;

    public AIOWriteHandler(AsynchronousSocketChannel channel) {
        this.channel = channel;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        //如果没有发送完，就继续发送直到完成
        if (buffer.hasRemaining()) {
            channel.write(buffer, buffer, this);
        } else {
            //创建新的Buffer
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            //异步读  第三个参数为接收消息回调的业务Handler
            channel.read(readBuffer, readBuffer, new AIOReadHandler(channel));
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            channel.close();
        } catch (IOException e) {
        }
    }
}
