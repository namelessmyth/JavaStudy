package com.sjj.mashibing.tank.netty;

import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.domain.MsgType;
import com.sjj.mashibing.tank.netty.gameObj.TankPlayer;
import com.sjj.mashibing.tank.netty.msg.TankMsg;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.embedded.EmbeddedChannel;
import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TankMsgTest {

    @Test
    void encode() {
        EmbeddedChannel channel = new EmbeddedChannel();
        channel.pipeline().addLast(new TankMsgEncoder());

        TankPlayer player = new TankPlayer(20, 30);
        TankMsg msg = new TankMsg(player);
        msg.setClientId("/127.0.0.1:12345");
        //模拟数据出站
        channel.writeOutbound(msg);
        //读取刚刚写出去的数据
        ByteBuf buf = channel.readOutbound();

        int length = buf.readInt();
        assertEquals(33, length);

        MsgType type = MsgType.values()[buf.readInt()];
        assertEquals(type, MsgType.TANK_MOVE);

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
        buf.writeInt(33);
        buf.writeInt(MsgType.TANK_MOVE.ordinal());

        buf.writeInt(20);
        buf.writeInt(30);
        buf.writeInt(Dir.UP.ordinal());
        buf.writeBoolean(true);
        buf.writeInt(Group.GOOD.ordinal());
        UUID id = UUID.randomUUID();
        buf.writeLong(id.getMostSignificantBits());
        buf.writeLong(id.getLeastSignificantBits());
        buf.writeCharSequence("/localhost", Charset.defaultCharset());

        channel.writeInbound(buf);
        //读取刚刚入站数据
        TankMsg msg = channel.readInbound();
        assertEquals(msg.getX(), 20);
    }
}