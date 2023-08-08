package com.sjj.mashibing.tank.simple;

import com.sjj.mashibing.tank.domain.Bullet;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.util.ResourceMgr;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.UUID;

/**
 * 玩家控制的坦克<br>
 *
 * @version 1.0
 * @date 2023/7/31
 */
@Data
@Slf4j
@ToString(exclude={"tf","rect"})
@NoArgsConstructor
public class TankPlayer {
    private UUID id = UUID.randomUUID();
    private int x = 100;
    private int y = 100;
    private final static int SPEED = 5;
    private Dir dir = Dir.DOWN;
    private boolean moving = false;
    private boolean living = true;
    private Group group = Group.GOOD;
    private TankFrame tf = null;
    private Rectangle rect = new Rectangle();
    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    public TankPlayer(int x, int y, Dir dir, Group group, TankFrame tf) {
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
     * @param g
     */
    public void paint(Graphics g) throws IOException {
        if(!isLiving()){
            return;
        }
        //使用坦克图片，绘制坦克
        switch(dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
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
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
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
        //根据坦克坐标计算子弹坐标，使子弹出现在坦克中部。
        int bX = this.x + TankPlayer.WIDTH/2 - Bullet.WIDTH/2;
        int bY = this.y + TankPlayer.HEIGHT/2 - Bullet.HEIGHT/2;
        Bullet b = new Bullet(this.id, bX, bY, this.dir, this.group, this.tf);

        tf.bullets.add(b);

        //Client.INSTANCE.send(new BulletNewMsg(b));
        //if(this.group == Group.GOOD) new Thread(()->new Audio("audio/tank_fire.wav").play()).start();
    }

    public void die() {
        this.living = false;
        int eX = this.getX() + TankPlayer.WIDTH/2 - Explode.WIDTH/2;
        int eY = this.getY() + TankPlayer.HEIGHT/2 - Explode.HEIGHT/2;
        TankFrame.INSTANCE.explodes.add(new Explode(eX, eY));
        log.info("this tank is die.{}", this);
    }
}
