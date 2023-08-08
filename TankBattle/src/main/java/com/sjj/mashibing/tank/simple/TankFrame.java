package com.sjj.mashibing.tank.simple;

import com.sjj.mashibing.tank.domain.Bullet;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.util.ConfigUtil;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 坦克大战主Frame类<br>
 *
 * @version 1.0
 * @date 2023/7/31
 */
@Slf4j
public class TankFrame extends Frame {
    public static final int GAME_WIDTH = ConfigUtil.getInt("frame.main.width");
    public static final int GAME_HEIGHT = ConfigUtil.getInt("frame.main.height");
    public static final int ENEMY_SIZE = ConfigUtil.getInt("tank.enemy.size");

    Random r = new Random();
    Image offScreenImage = null;
    TankPlayer myTank = new TankPlayer(GAME_WIDTH / 2 - 100, GAME_HEIGHT - 70, Dir.UP, Group.GOOD, this);
    //敌方坦克
    List<Tank> tanks = new ArrayList<>(ENEMY_SIZE);
    //子弹
    public List<Bullet> bullets = new ArrayList<Bullet>();
    //爆炸
    public List<Explode> explodes = new ArrayList<>();
    public static final TankFrame INSTANCE = new TankFrame();

    private TankFrame() throws HeadlessException {
        //创建游戏的主Frame
        this.setTitle("tank war");
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setLocation(400, 100);
        //加入主窗口的键盘事件监听，让键盘可以控制坦克
        this.addKeyListener(new TankKeyListener());

        int gap = GAME_WIDTH / ENEMY_SIZE;
        for (int i = 0; i < ENEMY_SIZE; i++) {
            Tank tank = new Tank(gap * i, 30, Dir.DOWN, Group.BAD, this);
            tanks.add(tank);
        }

        log.info("tank war Main frame initialization completed");
    }

    /**
     * 覆盖此方法，在frame创建时就执行。
     *
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        try {
            Color c = g.getColor();
            g.setColor(Color.WHITE);
            g.drawString("bullets: " + bullets.size(), 10, 45);
            g.drawString("enymies: " + tanks.size(), 10, 60);
            g.setColor(c);

            myTank.paint(g);
            for (Tank tank : tanks) {
                tank.paint(g);
            }
            for (int i = 0; i < bullets.size(); i++) {
                Bullet b = bullets.get(i);
                for (int i1 = 0; i1 < tanks.size(); i1++) {
                    b.collideWith(tanks.get(i1));
                }
                if (b.isLiving()) {
                    bullets.get(i).paint(g);
                }
            }

            for (int i = 0; i < explodes.size(); i++) {
                Explode b = explodes.get(i);
                b.paint(g);
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
            myTank.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            myTank.keyReleased(e);
        }
    }
}
