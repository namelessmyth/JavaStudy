package com.sjj.mashibing.tank.domain;

import com.sjj.mashibing.tank.netty.msg.TankMsg;

/**
 * 消息类型枚举类<br>
 * msgClass必须是Msg的子类，否则会报错<br>
 * @author namelessmyth
 * @date 2023/7/31
 */
public enum MsgType {
    /**
     * 坦克加入消息
     */
    JOIN(TankMsg.class.getName()),
    /**
     * 坦克移动消息
     */
    MOVE(TankMsg.class.getName());
    /**
     * 消息类型对应的类
     */
    String msgClass;

    MsgType(String msgClass) {
        this.msgClass = msgClass;
    }

    public String getMsgClass() {
        return msgClass;
    }
}
