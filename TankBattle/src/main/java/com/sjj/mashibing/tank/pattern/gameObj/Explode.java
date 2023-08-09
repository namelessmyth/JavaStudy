package com.sjj.mashibing.tank.pattern.gameObj;

import com.sjj.mashibing.tank.pattern.TankFrame;
import com.sjj.mashibing.tank.util.Audio;
import com.sjj.mashibing.tank.util.ResourceMgr;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;

/**
 * 爆炸效果类
 */
@Slf4j
@Data
@ToString
public class Explode extends GameObject {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
    private int step = 0;

    public Explode(int x, int y) {
        super();
        setX(x);
        setY(y);
        new Thread(() -> new Audio("audio/explode.wav").play()).start();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], getX(), getY(), null);
        if (step >= ResourceMgr.explodes.length) {
            log.info("explosion occurred ... {}", this);
            TankFrame.INSTANCE.objects.remove(this);
        }
    }

}
