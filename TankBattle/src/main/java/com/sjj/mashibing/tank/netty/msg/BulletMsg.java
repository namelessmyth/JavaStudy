package com.sjj.mashibing.tank.netty.msg;


import cn.hutool.core.bean.BeanUtil;
import com.sjj.mashibing.chatroom.Constants;
import com.sjj.mashibing.tank.domain.MsgType;
import com.sjj.mashibing.tank.netty.TankFrame;
import com.sjj.mashibing.tank.netty.gameObj.Bullet;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * 子弹消息<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/20
 */
@Data
@ToString(callSuper = true)
@Slf4j
@NoArgsConstructor
public class BulletMsg extends TankMsg implements Constants {
    private MsgType msgType = MsgType.BULLET_JOIN;
    private UUID playerId;

    public BulletMsg(Bullet b) {
        super();
        BeanUtil.copyProperties(b, this);
    }

    @Override
    public void handle() {
        Bullet b = TankFrame.INSTANCE.getGm().findById(getId(), Bullet.class);
        if (b == null) {
            b = new Bullet();
            BeanUtil.copyProperties(this, b);
            TankFrame.INSTANCE.getGm().add(b);
            log.info("Successfully join Bullet:{}", b);
        }
    }
}
