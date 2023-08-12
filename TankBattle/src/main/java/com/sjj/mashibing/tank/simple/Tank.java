package com.sjj.mashibing.tank.simple;

import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.util.ResourceMgr;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

/**
 * 地方-坦克<br>
 *
 * @version 1.0
 * @date 2023/7/31
 */
@Data
@Slf4j
@ToString(exclude = {"tf", "rect"})
@NoArgsConstructor
public class Tank implements Serializable {
    private static final long serialVersionUID = -6769165843909008043L;

    private UUID id = UUID.randomUUID();
    private int x = 100;
    private int y = 100;
    private final static int SPEED = 5;
    private Dir dir = Dir.DOWN;
    private boolean moving = true;
    private boolean living = true;
    private Group group = Group.BAD;
    private TankFrame tf = null;
    private Rectangle rect = new Rectangle();
    private Random random = new Random();
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }

    /**
     * 覆盖此方法后，会在frame创建时就执行。
     *
     * @param g
     */
    public void paint(Graphics g) throws IOException {
        if (!isLiving()) {
            return;
        }
        //使用坦克图片，绘制坦克
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
        }
        if (moving) {
            move();
        }
        if (random.nextInt(100) < 5) {
            fire();
        }
    }

    public void move() {
        int xNew = x;
        int yNew = y;
        switch (dir) {
            case LEFT:
                xNew = x - SPEED;
                break;
            case RIGHT:
                xNew = x + SPEED;
                break;
            case UP:
                yNew = y - SPEED;
                break;
            case DOWN:
                yNew = y + SPEED;
                break;
            default:
                break;
        }

        if (boundCheck(xNew, yNew)) {
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
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Bullet b = new Bullet(this.id, bX, bY, this.dir, this.group, this.tf);

        tf.bullets.add(b);

        //Client.INSTANCE.send(new BulletNewMsg(b));
        //if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public void die() {
        this.living = false;
        int eX = this.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
        int eY = this.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
        TankFrame.INSTANCE.tanks.remove(this);
        TankFrame.INSTANCE.explodes.add(new Explode(eX, eY));
        log.info("this tank is die.{}", this);
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

    /**
     * 更新坦克的长方形坐标
     */
    public void updateRect() {
        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
    }
}
