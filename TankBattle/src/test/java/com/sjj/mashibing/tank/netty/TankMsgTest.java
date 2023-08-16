package com.sjj.mashibing.tank.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TankMsgTest {

    @Test
    void encode() {
        EmbeddedChannel channel = new EmbeddedChannel();
        channel.pipeline().addLast(new TankMsgEncoder());
        //模拟出站数据
        channel.writeOutbound(new TankMsg(123, 34));
        //读取刚刚写出去的数据
        ByteBuf buf = channel.readOutbound();
        int x = buf.readInt();
        int y = buf.readInt();

        assertEquals(x, 123);
    }

    @Test
    void decode() {
        EmbeddedChannel channel = new EmbeddedChannel();
        channel.pipeline().addLast(new TankMsgDecoder());
        //模拟写入入站请求
        ByteBuf buf = Unpooled.buffer();
        buf.writeInt(3);
        buf.writeInt(4);
        channel.writeInbound(buf);
        //读取刚刚入站数据
        TankMsg msg = channel.readInbound();
        assertEquals(msg.getX(), 3);
    }
}