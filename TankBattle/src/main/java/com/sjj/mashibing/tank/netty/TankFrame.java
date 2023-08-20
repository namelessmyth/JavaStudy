package com.sjj.mashibing.tank.netty;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import com.sjj.mashibing.chatroom.Constants;
import com.sjj.mashibing.tank.netty.msg.TankMoveMsg;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

/**
 * 坦克大战主Frame类<br>
 *
 * @version 1.0
 * @date 2023/7/31
 */
@Slf4j
@Data
public class TankFrame extends Frame implements Constants {
    Image offScreenImage = null;
    GameModel gm;
    public static final TankFrame INSTANCE = new TankFrame();

    public static void main(String[] args) {
        INSTANCE.setVisible(true);
        log.info("tank war TankMain frame is visible");

        //new Thread(() -> new Audio("audio/war1.wav").loop()).start();
        new Thread(() -> {
            for (; ; ) {
                try {
                    //每隔25ms调用之前的绘制方法，相当于40桢动画
                    TimeUnit.MILLISECONDS.sleep(25);
                    INSTANCE.repaint();
                } catch (InterruptedException e) {
                    log.error("TankMain-InterruptedException:", e);
                }
            }
        }).start();
        //连接服务器
        TankClient.connect();
    }

    private TankFrame() throws HeadlessException {
        //创建游戏的主Frame
        this.setTitle("tank war");
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setLocation(400, 100);
        //加入主窗口的键盘事件监听，让键盘可以控制坦克
        this.addKeyListener(new TankKeyListener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        gm = new GameModel();
        log.info("tank war Main frame initialization completed");
    }


    @Override
    public void paint(Graphics g) {
        try {
            getGm().paint(g);
        } catch (Exception e) {
            log.error("TankFrame绘制异常：", e);
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

    public void save() {
        File file = FileUtil.file("tankBattle.dat");
        try {
            IoUtil.writeObj(new FileOutputStream(file), true, getGm());
        } catch (FileNotFoundException e) {
            log.error("save game exception.", e);
        }
        log.info("save game successfully!");
    }

    public void Load() {
        File file = FileUtil.file("tankBattle.dat");
        try {
            setGm(IoUtil.readObj(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            log.error("save game exception.", e);
        }
        log.info("load game successfully!");
    }

    /**
     * 继承的这个类已经实现了接口方法。所以继承这个类之后只要实现自己想要的方法即可
     */
    private class TankKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {
                default:
                    boolean result = getGm().getMyTank().keyPressed(e);
                    break;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keycode = e.getKeyCode();
            switch (keycode) {
                case KeyEvent.VK_S:
                    save();
                    break;
                case KeyEvent.VK_L:
                    Load();
                    break;
                default:
                    boolean result = getGm().getMyTank().keyReleased(e);
                    if (result) {
                        TankClient.send(new TankMoveMsg(TankFrame.INSTANCE.getGm().getMyTank()));
                    }
                    break;
            }
        }
    }
}
