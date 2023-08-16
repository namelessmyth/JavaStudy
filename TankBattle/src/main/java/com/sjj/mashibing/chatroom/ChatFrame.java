package com.sjj.mashibing.chatroom;

import cn.hutool.core.io.file.LineSeparator;
import com.sjj.mashibing.tank.util.ConfigUtil;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/15
 */
@Slf4j
public class ChatFrame extends Frame {
    public static final int GAME_WIDTH = ConfigUtil.getInt("chat.frame.width");
    public static final int GAME_HEIGHT = ConfigUtil.getInt("chat.frame.height");
    TextArea ta = new TextArea();
    TextField tf = new TextField();

    public static final ChatFrame INSTANCE = new ChatFrame();

    public static void main(String[] args) throws Exception {
        INSTANCE.setVisible(true);
        ChatClient.connect();
    }

    private ChatFrame() throws HeadlessException {
        //创建游戏的主Frame
        this.setTitle("chat room");
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        this.setLocation(800, 100);
        this.add(ta, BorderLayout.CENTER);
        this.add(tf, BorderLayout.SOUTH);

        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ChatClient.send(tf.getText());
                tf.setText("");
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ChatClient.close();
                System.exit(0);
            }
        });
        log.info("chat room Main frame initialization completed");
    }

    public void updateText(String text) {
        ta.setText(ta.getText() + Constants.LINE_SEPERATOR + text);
    }
}
