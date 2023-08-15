package com.sjj.mashibing.chatroom;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatServer {
    static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static void main(String[] args) throws Exception {
        //总管线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //接待员线程
        EventLoopGroup workerGroup = new NioEventLoopGroup(2);
        //服务器启动辅助类
        ServerBootstrap b = new ServerBootstrap();
        //放在第一位的是总管线程组，第二位的就是接待员线程组。
        b.group(bossGroup, workerGroup);
        //异步全双工
        b.channel(NioServerSocketChannel.class);
        //接收到客户端连接的处理，相当于BIO的accept
        b.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel sc) throws Exception {
                log.info("a client connected:{}", sc);
                sc.pipeline().addLast(new MyChildHandler());
            }
        });
        b.bind(8888).sync();
    }
}

@Slf4j
class MyChildHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ChatServer.clients.add(ctx.channel());
    }

    /**
     * 读取通道内的数据
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = null;
        try {
            buf = (ByteBuf) msg;
            ChatServer.clients.writeAndFlush(msg);
            log.info("ChatServer.clients.writeAndFlush:{}", msg);
        } finally {
            ReferenceCountUtil.release(buf);
        }
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
        log.error("exceptionCaught:", cause);
        ChatServer.clients.remove(ctx.channel());
        ctx.close();
    }
}