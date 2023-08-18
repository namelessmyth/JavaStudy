package com.sjj.mashibing.tank.netty.msg;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.IoUtil;
import com.sjj.mashibing.chatroom.Constants;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.domain.MsgType;
import com.sjj.mashibing.tank.netty.TankClient;
import com.sjj.mashibing.tank.netty.TankFrame;
import com.sjj.mashibing.tank.netty.gameObj.Tank;
import com.sjj.mashibing.tank.netty.gameObj.TankPlayer;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.UUID;

/**
 * 坦克移动消息说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/16
 */
@Data
@ToString(callSuper = true)
@Slf4j
@NoArgsConstructor
public class TankMoveMsg extends TankMsg implements Constants {
    private MsgType msgType = MsgType.MOVE;

    public TankMoveMsg(TankPlayer player) {
        super();
        BeanUtil.copyProperties(player, this);
    }

    @Override
    public void handle() {
        TankPlayer myTank = TankFrame.INSTANCE.getGm().getMyTank();
        if (getId() == null || getId().equals(myTank.getId())) {
            log.info("Ignore self messages");
            return;
        }
        Tank t = TankFrame.INSTANCE.getGm().findTankById(getId());
        if (t != null) {
            BeanUtil.copyProperties(this, t, new String[]{"id"});
            log.info("Successfully moved tank:{}", t);
        } else {
            log.warn("No tanks found in GameObject:{}", this);
        }
    }
}
