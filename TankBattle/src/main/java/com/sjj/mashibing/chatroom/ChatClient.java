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
 * 聊天室-客户端<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/13
 */
@Slf4j
public class ChatClient {
    private static SocketChannel channel;

    /**
     * 与服务端建立连接的方法
     */
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
            log.info("the chat client has been closed.");
        } catch (Exception e) {
            log.error("ChatClient.connect.Exception.", e);
        } finally {
            group.shutdownGracefully();
        }
    }

    /**
     * 向服务端发送聊天消息的方法
     * @param msg 聊天内容
     */
    public static void send(String msg) {
        channel.writeAndFlush(Unpooled.copiedBuffer(msg.getBytes()));
        log.info("client.send().{}", msg);
    }

    /**
     * 关闭客户端方法，向服务端发送特定消息告知其删除本客户端。
     */
    public static void close() {
        send("__88__");
        channel.close();
    }
}

@Slf4j
class MyClientHandler extends ChannelInboundHandlerAdapter {
    /**
     * 读取服务端数据
     * @param msg 服务端数据
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
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("connected to server.");
    }

    /**
     * 异常处理
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("chat client exceptionCaught:", cause);
        super.exceptionCaught(ctx, cause);
    }
}
