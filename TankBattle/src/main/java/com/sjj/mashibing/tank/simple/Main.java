package com.sjj.mashibing.tank.simple;

import com.sjj.mashibing.tank.simple.TankFrame;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/7/31
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("tank war starting ...");
        TankFrame.INSTANCE.setVisible(true);
        for (; ; ) {
            try {
                //每隔25ms调用之前的绘制方法，相当于40桢动画
                TimeUnit.MILLISECONDS.sleep(25);
                TankFrame.INSTANCE.repaint();
            } catch (InterruptedException e) {
                log.error("paint-InterruptedException:", e);
            }
        }
    }

    public static void newFrame() {
        Frame f = new Frame("tank war");
        f.setLocation(400,100);
        f.setSize(800,600);
        f.setVisible(true);
    }
}
