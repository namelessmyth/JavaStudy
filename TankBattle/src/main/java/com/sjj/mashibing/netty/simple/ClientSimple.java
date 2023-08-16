package com.sjj.mashibing.netty.simple;

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
public class ClientSimple {
    public static void main(String[] args) throws Exception {
        //线程池
        EventLoopGroup group = new NioEventLoopGroup(1);
        Bootstrap b = new Bootstrap();
        b.group(group);
        b.channel(NioSocketChannel.class);
        b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new MyClientHandler());
            }
        });
        ChannelFuture cf = b.connect("localhost", 8888).sync();
        //直到服务器被关闭，否则一直阻塞。
        cf.channel().closeFuture().sync();
        log.info("client is close.");
        group.shutdownGracefully();
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
        log.info("channelRead.msg:{}", buf);
    }

    /**
     * 连接刚建立时的事件处理
     *
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf b = Unpooled.copiedBuffer("mashibing".getBytes(StandardCharsets.UTF_8));
        ctx.writeAndFlush(b);
        log.info("channelActive.msg:{}", b);
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
