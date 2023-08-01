package com.sjj.mashibing.tank;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.TimeUnit;

/**
 * 类功能说明<br>
 * @version 1.0
 * @date 2023/7/31
 */
@Slf4j
public class TankFrame extends Frame {
    Tank mytank;

    public TankFrame() throws HeadlessException {
        mytank = new Tank();
        this.setTitle("tank war");
        this.setLocation(400, 100);
        this.setSize(800, 600);
        this.setVisible(true);
        this.addKeyListener(new TankKeyListener());
    }

    /**
     * 覆盖此方法后，会在frame创建时就执行。
     * @param g
     */
    @Override
    public void paint(Graphics g) {
        mytank.paint(g);
    }

    /**
     * 继承的这个类已经实现了接口方法。所以继承这个类之后只要实现自己想要的方法即可
     */
    private class TankKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            mytank.keyPressed(e);
        }
    }
}
