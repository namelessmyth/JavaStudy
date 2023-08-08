package com.sjj.mashibing.tank.simple;

import com.sjj.mashibing.tank.util.ResourceMgr;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * 爆炸效果类
 */
@Slf4j
@Data
@ToString
public class Explode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int x, y;
    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) {
            log.info("explosion occurred ... {}", this);
            TankFrame.INSTANCE.explodes.remove(this);
        }
    }

}
