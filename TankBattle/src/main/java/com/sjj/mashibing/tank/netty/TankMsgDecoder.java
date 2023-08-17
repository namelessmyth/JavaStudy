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
        if (byteBuf.readableBytes() < 33) {
            return;
        }
        int length = byteBuf.readInt();
        byte [] bs = new byte [length];
        TankMsg msg = TankMsg.parse(bs);

        list.add(msg);
    }
}
