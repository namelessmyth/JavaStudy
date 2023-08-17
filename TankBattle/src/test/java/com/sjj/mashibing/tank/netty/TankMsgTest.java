package com.sjj.mashibing.tank.netty;

import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.pattern.gameObj.TankPlayer;
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

        TankPlayer player = new TankPlayer(20, 30);
        //模拟数据出站
        channel.writeOutbound(new TankMsg(player));
        //读取刚刚写出去的数据
        ByteBuf buf = channel.readOutbound();

        int length = buf.readInt();
        assertEquals(33, length);

        int x = buf.readInt();
        int y = buf.readInt();
        assertEquals(20, x);
        assertEquals(30, y);

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