package com.sjj.mashibing.tank.netty.msg;

import com.sjj.mashibing.chatroom.Constants;
import com.sjj.mashibing.tank.domain.MsgType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/16
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class Msg implements Constants {
    private MsgType msgType = MsgType.TANK_JOIN;
    private UUID id = UUID.randomUUID();
    private String clientId;

    /**
     * 将消息体转换成 byte[]
     * @return
     */
    public abstract byte[] toBytes();

    /**
     * 将byte[]转换成消息体对象
     * @param bs
     * @author namelessmyth
     * @return T
     */
    public abstract <T extends Msg> T parse(byte[] bs);

    /**
     * 客户端接收到消息后的行为
     * @return
     */
    public abstract void handle();
}
