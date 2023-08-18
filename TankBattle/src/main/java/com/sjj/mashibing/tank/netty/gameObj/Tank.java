package com.sjj.mashibing.tank.netty.gameObj;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.Matcher;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.netty.TankFrame;
import com.sjj.mashibing.tank.netty.msg.TankMsg;
import com.sjj.mashibing.tank.util.ResourceMgr;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * 地方-坦克<br>
 *
 * @version 1.0
 * @date 2023/7/31
 */
@Data
@Slf4j
@ToString(exclude = {"rect"})
@NoArgsConstructor
public class Tank extends GameObject {
    private final static int SPEED = 5;
    private Dir dir = Dir.DOWN;
    private boolean moving = true;
    private Group group = Group.BAD;
    private Random random = new Random();
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    public Tank(int x, int y, Dir dir, Group group) {
        super();
        setX(x);
        setY(y);
        setW(WIDTH);
        setH(HEIGHT);
        this.dir = dir;
        this.group = group;

        updateRect();
    }

    public Tank(TankMsg msg) {
        super();
        setW(WIDTH);
        setH(HEIGHT);
        BeanUtil.copyProperties(msg, this);

        updateRect();
    }

    /**
     * 覆盖此方法后，会在frame创建时就执行。
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) throws IOException {
        if (!isLiving()) {
            return;
        }
        //使用坦克图片，绘制坦克
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, getX(), getY(), null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, getX(), getY(), null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, getX(), getY(), null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, getX(), getY(), null);
                break;
        }
        if (moving) {
            move();
        }
        if (random.nextInt(100) < 0) {
            fire();
        }
    }

    public void move() {
        int xNew = getX();
        int yNew = getY();
        switch (dir) {
            case LEFT:
                xNew = getX() - SPEED;
                break;
            case RIGHT:
                xNew = getX() + SPEED;
                break;
            case UP:
                yNew = getY() - SPEED;
                break;
            case DOWN:
                yNew = getY() + SPEED;
                break;
            default:
                break;
        }

        if (boundCheck(xNew, yNew)) {
            setXo(getX());
            setYo(getY());
            setX(xNew);
            setY(yNew);
            updateRect();
        }

        //移动之后，随机获取一个方向。
        if (random.nextInt(100) < 5) {
            this.setDir(Dir.random());
        }
    }

    public void fire() {
        //根据坦克坐标计算子弹坐标，使子弹出现在坦克中部。
        int bX = getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Bullet b = new Bullet(getId(), bX, bY, this.dir, this.group);

        TankFrame.INSTANCE.getGm().add(b);
    }

    @Override
    public void die() {
        super.die();
        int eX = this.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
        int eY = this.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
        TankFrame.INSTANCE.getGm().add(new Explode(eX, eY));
        log.info("this tank is die. size of tanks:{}, this:{}", CollUtil.count(TankFrame.INSTANCE.getGm().getObjects(),
                new Matcher<GameObject>() {
                    @Override
                    public boolean match(GameObject gameObject) {
                        if (gameObject instanceof Tank) {
                            return true;
                        }
                        return false;
                    }
                }), this);
    }

    /**
     * 检查对象是否超出窗口边界
     */
    public boolean boundCheck(int x, int y) {
        if (x < 0 || x > TankFrame.GAME_WIDTH - WIDTH || y < 30 || y > TankFrame.GAME_HEIGHT - HEIGHT) {
            return false;
        }
        return true;
    }

    public void updateRect() {
        getRect().x = getX();
        getRect().y = getY();
        getRect().width = getW();
        getRect().height = getH();
    }

    public void back() {
        setX(getXo());
        setY(getYo());
        updateRect();
    }
}
