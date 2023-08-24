package com.sjj.mashibing.chatroom;

import cn.hutool.core.util.StrUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * 聊天室-服务端
 */
@Slf4j
public class ChatServer {
    static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static void start(){
        //总管线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //接待员线程
        EventLoopGroup workerGroup = new NioEventLoopGroup(2);
        try {
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
            log.info("chat server has been started");
            ChannelFuture cf = b.bind(8888).sync();
            cf.channel().closeFuture().sync();
        } catch (Exception e) {
            log.error("TankServer.exception", e);
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
            log.info("chat server has been closed");
        }
    }
}

@Slf4j
class MyChildHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ServerFrame.INSTANCE.updateClient("client connected:"+ctx.channel().remoteAddress());
        ChatServer.clients.add(ctx.channel());
    }

    /**
     * 读取客户端通道内的数据
     *
     * @param msg 客户端消息
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        String str = buf.toString(StandardCharsets.UTF_8);
        log.info("channelRead().input,string:{},buf:{}", str, buf);
        if (StrUtil.equalsIgnoreCase(str, "__88__")) {
            ChatServer.clients.remove(ctx.channel());
            ctx.close();
            ServerFrame.INSTANCE.updateClient("client closed>"+ctx.channel().remoteAddress());
            log.info("The chat client has been closed:{}", ctx.channel());
        } else {
            ChatServer.clients.writeAndFlush(msg);
            ServerFrame.INSTANCE.updateMsg(ctx.channel().remoteAddress() + ">" + str);
            log.info("TankServer.clients.writeAndFlush:{}", msg);
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
        log.error("TankServer.exceptionCaught:", cause);
        ChatServer.clients.remove(ctx.channel());
        ctx.close();
    }
}