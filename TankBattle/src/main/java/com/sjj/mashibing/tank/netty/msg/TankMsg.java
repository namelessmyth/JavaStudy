package com.sjj.mashibing.tank.netty.msg;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.IoUtil;
import com.sjj.mashibing.chatroom.Constants;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
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
 * 坦克消息<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/16
 */
@Data
@ToString(callSuper = true)
@Slf4j
@NoArgsConstructor
public class TankMsg extends Msg implements Constants {
    private int x, y;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    private Group group = Group.GOOD;

    public TankMsg(int x, int y) {
        super();
        setX(x);
        setY(y);
    }

    public TankMsg(TankPlayer player) {
        super();
        BeanUtil.copyProperties(player, this);
    }

    @Override
    public byte[] toBytes() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);

        try {
            dos.writeInt(x);
            dos.writeInt(y);
            dos.writeInt(dir.ordinal());
            dos.writeBoolean(moving);
            dos.writeInt(group.ordinal());
            dos.writeLong(getId().getMostSignificantBits());
            dos.writeLong(getId().getLeastSignificantBits());
            //dos.writeUTF(getClientId());
            dos.flush();
        } catch (IOException e) {
            log.error("", e);
        } finally {
            IoUtil.close(baos);
            IoUtil.close(dos);
        }
        return baos.toByteArray();
    }

    @Override
    public TankMsg parse(byte[] bs) {
        ByteArrayInputStream bais = new ByteArrayInputStream(bs);
        DataInputStream dis = new DataInputStream(bais);
        try {
            this.setX(dis.readInt());
            this.setY(dis.readInt());
            this.setDir(Dir.values()[dis.readInt()]);
            this.setMoving(dis.readBoolean());
            this.setGroup(Group.values()[dis.readInt()]);
            this.setId(new UUID(dis.readLong(), dis.readLong()));
            //this.setClientId(dis.readUTF());
        } catch (Exception e) {
            log.error("", e);
        } finally {
            IoUtil.close(bais);
            IoUtil.close(dis);
        }
        return this;
    }

    @Override
    public void handle() {
        TankPlayer myTank = TankFrame.INSTANCE.getGm().getMyTank();
        if (getId() == null || getId().equals(myTank.getId())
                || TankFrame.INSTANCE.getGm().findTankById(getId()) != null) {
            log.info("tankmsg is self:{}, is exists:{}", getId().equals(myTank.getId())
                    , TankFrame.INSTANCE.getGm().findTankById(getId()) != null);
            return;
        }
        Tank t = new Tank(this);
        TankFrame.INSTANCE.getGm().add(t);
        log.info("add tank to client:{}", this);
        //重新发送一下当前的这辆坦克信息，避免后加入的坦克无法接收到前面的坦克信息。
        TankClient.send(new TankMsg(myTank));
    }
}
