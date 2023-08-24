package com.sjj.mashibing.chatroom;

import com.sjj.mashibing.tank.util.ConfigUtil;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 聊天室-服务端界面<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/15
 */
@Slf4j
public class ServerFrame extends Frame {
    public static final int GAME_WIDTH = ConfigUtil.getInt("server.frame.width");
    public static final int GAME_HEIGHT = ConfigUtil.getInt("server.frame.height");
    TextArea tmsg = new TextArea("messages:");
    TextArea tclient = new TextArea("clients:");

    public static final ServerFrame INSTANCE = new ServerFrame();

    public static void main(String[] args) throws Exception {
        INSTANCE.setVisible(true);
        ChatServer.start();
    }

    private ServerFrame() throws HeadlessException {
        //创建游戏的主Frame
        this.setTitle("chat room");
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setLocation(100, 100);

        tmsg.setFont(new Font("Calibri",Font.PLAIN,20));
        tclient.setFont(new Font("Calibri",Font.PLAIN,20));

        Panel p = new Panel(new GridLayout(1, 2));
        p.add(tmsg);
        p.add(tclient);
        this.add(p);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        log.info("Server Main frame initialization completed");
    }

    public void updateMsg(String text) {
        tmsg.setText(tmsg.getText() + Constants.LINE_SEPERATOR + text);
    }

    public void updateClient(String text) {
        tclient.setText(tclient.getText() + Constants.LINE_SEPERATOR + text);
    }
}
