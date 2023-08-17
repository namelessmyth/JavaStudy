package com.sjj.mashibing.tank.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 坦克大战消息编码器<br>
 * 用于客户端向服务器发送消息时使用。
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/16
 */
public class TankMsgEncoder extends MessageToByteEncoder<TankMsg> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, TankMsg tankMsg, ByteBuf byteBuf) throws Exception {
        byte [] bs = tankMsg.toBytes();
        byteBuf.writeInt(bs.length);
        byteBuf.writeBytes(bs);
    }
}
