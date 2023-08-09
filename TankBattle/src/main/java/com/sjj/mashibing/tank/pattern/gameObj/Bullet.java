package com.sjj.mashibing.tank.pattern.gameObj;

import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.pattern.TankFrame;
import com.sjj.mashibing.tank.util.ResourceMgr;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.UUID;

@Data
@Slf4j
@ToString
public class Bullet extends GameObject {
    private static final int SPEED = 8;

    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private UUID playerId;
    private int x, y;
    private Dir dir;
    //判断字段是否活着（超出边界）
    private boolean living = true;
    private Group group = Group.BAD;

    public Bullet(UUID playerId, int x, int y, Dir dir, Group group) {
        super();
        this.playerId = playerId;
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        setRect(new Rectangle());
        getRect().x = getX();
        getRect().y = getY();
        getRect().width = WIDTH;
        getRect().height = HEIGHT;
    }

    public void die() {
        this.living = false;
        TankFrame.INSTANCE.remove(this);
        log.info("this bullet is die:{}", this);
    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        boundCheck();

        //移动的同时修改长方形坐标
        getRect().x = this.x;
        getRect().y = this.y;
    }

    /**
     * 检查子弹是否超出窗口边界
     */
    public void boundCheck() {
        if (x < 0 || x > TankFrame.GAME_WIDTH || y < 30 || y > TankFrame.GAME_HEIGHT) {
            living = false;
            TankFrame.INSTANCE.remove(this);
        }
    }

    public boolean collideWith(Tank tank) {
        if (this.playerId.equals(tank.getId()) || this.getGroup() == tank.getGroup()) {
            //防止自相残杀
            return false;
        }
        if (this.isLiving() && tank.isLiving() && this.getRect().intersects(tank.getRect())) {
            this.die();
            tank.die();
            //Client.INSTANCE.send(new TankDieMsg(this.id, tank.getId()));
            return true;
        }
        return false;
    }

    public void paint(Graphics g) {
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }
        move();
    }
}
