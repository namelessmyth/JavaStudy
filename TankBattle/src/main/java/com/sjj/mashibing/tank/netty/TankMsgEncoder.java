package com.sjj.mashibing.tank.netty;

import com.sjj.mashibing.tank.netty.msg.Msg;
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
public class TankMsgEncoder extends MessageToByteEncoder<Msg> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Msg msg, ByteBuf byteBuf) throws Exception {
        byte [] bs = msg.toBytes();
        byteBuf.writeInt(bs.length);
        byteBuf.writeInt(msg.getMsgType().ordinal());
        byteBuf.writeBytes(bs);
    }
}
