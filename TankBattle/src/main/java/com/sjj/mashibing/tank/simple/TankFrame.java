package com.sjj.mashibing.tank.simple;

import com.sjj.mashibing.tank.domain.Bullet;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * 坦克大战主Frame类<br>
 *
 * @version 1.0
 * @date 2023/7/31
 */
@Slf4j
public class TankFrame extends Frame {
    public static final TankFrame INSTANCE = new TankFrame();
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;
    public static final int TANK_SIZE = 30;

    Random r = new Random();
    Image offScreenImage = null;
    Tank mytank = new Tank(r.nextInt(GAME_WIDTH - TANK_SIZE), r.nextInt(GAME_HEIGHT + TANK_SIZE), Dir.UP, Group.GOOD, this);
    Tank enemy = new Tank(r.nextInt(GAME_WIDTH - TANK_SIZE), r.nextInt(GAME_HEIGHT + TANK_SIZE), Dir.UP, Group.BAD, this);
    Bullet bullet = new Bullet(UUID.randomUUID(), mytank.getX(), mytank.getY(), Dir.UP, Group.GOOD, this);
    //子弹
    public List<Bullet> bullets = new ArrayList<Bullet>();

    private TankFrame() throws HeadlessException {
        //创建游戏的主Frame
        this.setTitle("tank war");
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setLocation(400, 100);

        //加入主窗口的键盘事件监听，让键盘可以控制坦克
        this.addKeyListener(new TankKeyListener());
    }

    /**
     * 覆盖此方法后，会在frame创建时就执行。
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        try {
            mytank.paint(g);
            enemy.paint(g);
            for (int i = 0; i < bullets.size(); i++) {
                bullets.get(i).paint(g);
            }
        } catch (IOException e) {
            log.error("坦克绘制异常：", e);
        }
    }

    /**
     * 用于解决图形闪烁问题。现在内存中画好图形，再让显卡一次性加载到现存中显示。
     * 如果把图形一点点传给显存，就会出现图片一点点刷新，也就是闪烁问题。
     *
     * @param g Graphics 显卡的画笔
     */
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            //创建一个和窗口一样大的Image对象（内存中）
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        //得到内存中的画笔（Graphics对象）
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        //在内存中先把这个图形画好
        paint(gOffScreen);
        //传给显卡显存的画笔，让图形显示到显示器上
        g.drawImage(offScreenImage, 0, 0, null);
    }

    /**
     * 继承的这个类已经实现了接口方法。所以继承这个类之后只要实现自己想要的方法即可
     */
    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            mytank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            mytank.keyReleased(e);
        }
    }
}
