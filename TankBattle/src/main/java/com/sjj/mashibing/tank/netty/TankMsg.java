package com.sjj.mashibing.tank.netty;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.SerializeUtil;
import com.sjj.mashibing.chatroom.Constants;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.domain.MsgType;
import com.sjj.mashibing.tank.pattern.gameObj.Tank;
import com.sjj.mashibing.tank.pattern.gameObj.TankPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
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
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class TankMsg implements Constants {
    private UUID id = UUID.randomUUID();
    private int x, y;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    private Group group = Group.GOOD;
    private MsgType msgType;

    public TankMsg(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public TankMsg(TankPlayer player) {
        BeanUtil.copyProperties(player, this);
    }

    public byte[] toBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        try {
            dos.writeInt(x);
            dos.writeInt(y);
            dos.writeInt(dir.ordinal());
            dos.writeBoolean(moving);
            dos.writeInt(group.ordinal());
            dos.writeLong(id.getMostSignificantBits());
            dos.writeLong(id.getLeastSignificantBits());
            dos.flush();
        } catch (IOException e) {
            log.error("", e);
        } finally {
            IoUtil.close(baos);
            IoUtil.close(dos);
        }
        return baos.toByteArray();
    }


    public static TankMsg parse(byte[] bs) {
        TankMsg result = new TankMsg();
        ByteArrayInputStream bais = new ByteArrayInputStream(bs);
        DataInputStream dis = new DataInputStream(bais);
        try {
            result.setX(dis.readInt());
            result.setY(dis.readInt());
            result.setDir(Dir.values()[dis.readInt()]);
            result.setMoving(dis.readBoolean());
            result.setGroup(Group.values()[dis.readInt()]);
            result.setId(new UUID(dis.readLong(), dis.readLong()));
        } catch (Exception e) {
            log.error("", e);
        } finally {
            IoUtil.close(bais);
            IoUtil.close(dis);
        }
        return result;
    }

    public void handle() {
        TankPlayer myTank = TankFrame.INSTANCE.getGm().getMyTank();
        if (id == null || id.equals(myTank.getId())
                || TankFrame.INSTANCE.getGm().findTankById(id) != null) {
            log.info("tankmsg is self:{}, is exists:{}", id.equals(myTank.getId())
                    , TankFrame.INSTANCE.getGm().findTankById(id) != null);
            return;
        }
        Tank t = new Tank(this);
        if (t.getRect().intersects(myTank.getRect())) {
            t.setX(TankFrame.INSTANCE.r.nextInt(GAME_WIDTH));
            t.setY(TankFrame.INSTANCE.r.nextInt(GAME_HEIGHT) - 30);
            log.info("reset x y");
        }
        TankFrame.INSTANCE.getGm().add(t);
        log.info("add tank to client:{}", this);
        //重新发送一下当前的这辆坦克信息，避免后加入的坦克无法接收到前面的坦克信息。
        TankClient.send(new TankMsg(myTank));
    }
}
