package com.sjj.mashibing.tank.pattern.gameObj;

import cn.hutool.core.util.ReflectUtil;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.pattern.TankFrame;
import com.sjj.mashibing.tank.pattern.strategy.FireStrategy;
import com.sjj.mashibing.tank.util.Audio;
import com.sjj.mashibing.tank.util.ConfigUtil;
import com.sjj.mashibing.tank.util.ResourceMgr;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 * 玩家控制的坦克<br>
 *
 * @version 1.0
 * @date 2023/7/31
 */
@Data
@Slf4j
@ToString(exclude = {"rect"})
@NoArgsConstructor
public class TankPlayer extends GameObject {
    private final static int SPEED = 5;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    private Group group = Group.GOOD;
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    private FireStrategy fireStrategy;

    public TankPlayer(int x, int y) {
        super();
        setX(x);
        setY(y);
        setW(WIDTH);
        setH(HEIGHT);

        getRect().x = getX();
        getRect().y = getY();
        getRect().width = WIDTH;
        getRect().height = HEIGHT;
        fireStrategy = ReflectUtil.newInstance(ConfigUtil.getStr("tank.player.fire.strategy"));
    }

    public TankPlayer(int x, int y, Dir dir, Group group) {
        super();
        setX(x);
        setY(y);
        setW(WIDTH);
        setH(HEIGHT);
        this.dir = dir;
        this.group = group;

        updateRect();
        fireStrategy = ReflectUtil.newInstance(ConfigUtil.getStr("tank.player.fire.strategy"));
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
    }

    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        switch (keycode) {
            case KeyEvent.VK_LEFT:
                dir = Dir.LEFT;
                moving = true;
                break;
            case KeyEvent.VK_RIGHT:
                dir = Dir.RIGHT;
                moving = true;
                break;
            case KeyEvent.VK_UP:
                dir = Dir.UP;
                moving = true;
                break;
            case KeyEvent.VK_DOWN:
                dir = Dir.DOWN;
                moving = true;
                break;
            default:
                break;
        }
        if (moving) {
            move();
        }
    }

    public void move() {
        new Thread(() -> new Audio("audio/tank_move.wav").play()).start();

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
            setX(xNew);
            setY(yNew);
            updateRect();
        }
    }

    public void keyReleased(KeyEvent e) {
        int keycode = e.getKeyCode();
        switch (keycode) {
            case KeyEvent.VK_LEFT:
                moving = false;
                break;
            case KeyEvent.VK_RIGHT:
                moving = false;
                break;
            case KeyEvent.VK_UP:
                moving = false;
                break;
            case KeyEvent.VK_DOWN:
                moving = false;
                break;
            case KeyEvent.VK_CONTROL:
                fire();
                break;
            default:
                break;
        }
    }

    public void fire() {
        new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
        fireStrategy.fire(this);
    }

    @Override
    public void die() {
        super.die();
        int eX = this.getX() + TankPlayer.WIDTH / 2 - Explode.WIDTH / 2;
        int eY = this.getY() + TankPlayer.HEIGHT / 2 - Explode.HEIGHT / 2;
        TankFrame.INSTANCE.getGm().add(new Explode(eX, eY));
        log.info("this tank is die.{}", this);
    }

    /**
     * 检查对象是否超出窗口边界
     */
    public boolean boundCheck(int x, int y) {
        if (x < 0 || x > TankFrame.GAME_WIDTH - WIDTH || y < 30 || y > TankFrame.GAME_HEIGHT - HEIGHT) {
            log.info("坐标超出边界，x:{}，y:{}", x, y);
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
}
