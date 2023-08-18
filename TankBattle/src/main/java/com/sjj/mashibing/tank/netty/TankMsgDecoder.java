package com.sjj.mashibing.tank.netty;

import cn.hutool.core.util.ReflectUtil;
import com.sjj.mashibing.tank.domain.MsgType;
import com.sjj.mashibing.tank.netty.msg.Msg;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static com.sjj.mashibing.tank.domain.MsgType.values;

/**
 * 坦克大战消息解码器<br>
 * 用于服务端接收客户端消息时使用。
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/16
 */
@Slf4j
public class TankMsgDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.readableBytes() < 8) {
            log.info("The message length cannot be less than 8 bits");
            return;
        }
        byteBuf.markReaderIndex();
        int length = byteBuf.readInt();
        if(byteBuf.readableBytes() < length){
            byteBuf.resetReaderIndex();
            log.info("The message has not been fully transmitted");
            return;
        }
        MsgType type = values()[byteBuf.readInt()];
        byte [] bs = new byte [length];
        byteBuf.readBytes(bs);
        //根据不通的消息类型，初始化不通的消息类
        Msg msg = ReflectUtil.newInstance(type.getMsgClass());
        msg.parse(bs);
        list.add(msg);
    }
}
