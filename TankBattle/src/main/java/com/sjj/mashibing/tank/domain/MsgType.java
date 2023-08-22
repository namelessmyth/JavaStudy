package com.sjj.mashibing.tank.domain;

import com.sjj.mashibing.tank.netty.msg.BulletMsg;
import com.sjj.mashibing.tank.netty.msg.TankDieMsg;
import com.sjj.mashibing.tank.netty.msg.TankMoveMsg;
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
    TANK_JOIN(TankMsg.class.getName()),
    /**
     * 坦克移动消息
     */
    TANK_MOVE(TankMoveMsg.class.getName()),
    /**
     * 坦克阵亡消息
     */
    TANK_DIE(TankDieMsg.class.getName()),
    /**
     * 子弹消息
     */
    BULLET_JOIN(BulletMsg.class.getName()),
    /**
     * 子弹阵亡消息
     */
    BULLET_DIE(BulletMsg.class.getName());
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
