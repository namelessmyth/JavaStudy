package com.sjj.mashibing.tank.pattern.gameObj;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Matcher;
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
    private Dir dir;
    //判断字段是否活着（超出边界）
    private boolean living = true;
    private Group group = Group.BAD;

    public Bullet(UUID playerId, int x, int y, Dir dir, Group group) {
        super();
        this.playerId = playerId;
        setX(x);
        setY(y);
        setH(HEIGHT);
        setW(WIDTH);
        this.dir = dir;
        this.group = group;

        updateRect();
    }

    public void die() {
        this.living = false;
        TankFrame.INSTANCE.remove(this);
        //log.info("this bullet is die:{}", this);
        log.info("this bullet is die. size of bullet:{}, this:{}", CollUtil.count(TankFrame.INSTANCE.objects,
                new Matcher<GameObject>() {
                    @Override
                    public boolean match(GameObject gameObject) {
                        if (gameObject instanceof Bullet) {
                            return true;
                        }
                        return false;
                    }
                }), this);
    }

    private void move() {
        switch (dir) {
            case LEFT:
                setX(getX() - SPEED);
                break;
            case UP:
                setY(getY() - SPEED);
                break;
            case RIGHT:
                setX(getX() + SPEED);
                break;
            case DOWN:
                setY(getY() + SPEED);
                break;
        }
        boundCheck();
        //移动的同时修改长方形坐标
        updateRect();
    }

    /**
     * 检查子弹是否超出窗口边界
     */
    public void boundCheck() {
        if (getX() < 0 || getX() > TankFrame.GAME_WIDTH || getY() < 30 || getY() > TankFrame.GAME_HEIGHT) {
            living = false;
            TankFrame.INSTANCE.remove(this);
        }
    }

    public boolean collideWith(Tank tank) {
        if (this.playerId.equals(tank.getId()) || this.getGroup() == tank.getGroup()) {
            //防止自相残杀
            return true;
        }
        if (this.isLiving() && tank.isLiving() && this.getRect().intersects(tank.getRect())) {
            this.die();
            tank.die();
            return false;
        }
        return true;
    }

    @Override
    public void paint(Graphics g) {
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, getX(), getY(), null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, getX(), getY(), null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, getX(), getY(), null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, getX(), getY(), null);
                break;
        }
        move();
    }

    public void updateRect() {
        getRect().x = getX();
        getRect().y = getY();
        getRect().width = getW();
        getRect().height = getH();
    }
}
