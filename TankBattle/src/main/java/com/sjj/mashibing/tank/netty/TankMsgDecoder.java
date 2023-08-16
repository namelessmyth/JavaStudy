package com.sjj.mashibing.tank.netty;

import com.sjj.mashibing.tank.simple.Tank;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.util.List;

/**
 * 坦克大战消息解码器<br>
 * 用于服务端接收客户端消息时使用。
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/16
 */
public class TankMsgDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 8) {
            return;
        }
        int x = byteBuf.readInt();
        int y = byteBuf.readInt();

        list.add(new TankMsg(x, y));
    }
}
