package com.sjj.mashibing.tank.netty;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.SerializeUtil;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.pattern.gameObj.TankPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
@NoArgsConstructor
@AllArgsConstructor
public class TankMsg {
    private UUID id = UUID.randomUUID();
    private int x, y, w, h;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    private Group group = Group.GOOD;

    public TankMsg(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public TankMsg(TankPlayer player) {
        BeanUtil.copyProperties(player, this);
    }

    public static TankMsg parse(byte[] bs) {
        TankMsg result = null;
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
            e.printStackTrace();
        } finally {
            IoUtil.close(bais);
            IoUtil.close(dis);
        }
        return result;
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
            e.printStackTrace();
        } finally {
            IoUtil.close(baos);
            IoUtil.close(dos);
        }

        return baos.toByteArray();
    }
}
