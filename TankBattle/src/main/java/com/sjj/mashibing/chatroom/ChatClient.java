package com.sjj.mashibing.chatroom;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/13
 */
@Slf4j
public class ChatClient {
    private static SocketChannel channel;

    public static void connect() {
        EventLoopGroup group = new NioEventLoopGroup(1);
        try {
            Bootstrap b = new Bootstrap();
            b.group(group);
            b.channel(NioSocketChannel.class);
            b.handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    channel = ch;
                    ch.pipeline().addLast(new MyClientHandler());
                }
            });
            ChannelFuture cf = b.connect("localhost", 8888).sync();
            //直到服务器被关闭，否则一直阻塞。
            cf.channel().closeFuture().sync();
            log.info("client is close.");
        } catch (Exception e) {
            log.error("Exception.", e);
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void send(String msg) {
        channel.writeAndFlush(Unpooled.copiedBuffer(msg.getBytes()));
        log.info("client.send().{}",msg);
    }

    public static void close() {
        send("88");
        channel.close();
    }
}

@Slf4j
class MyClientHandler extends ChannelInboundHandlerAdapter {
    /**
     * 读取通道内的数据
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        String text = buf.toString(StandardCharsets.UTF_8);
        ChatFrame.INSTANCE.updateText(text);
        log.info("channelRead.msg:{}", text);
    }

    /**
     * 连接刚建立时的事件处理
     *
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("connected to server.");
    }

    /**
     * 异常处理
     *
     * @param ctx
     * @param cause
     * @throws Exception
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
