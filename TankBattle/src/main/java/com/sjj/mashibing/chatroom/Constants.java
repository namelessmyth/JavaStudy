package com.sjj.mashibing.chatroom;

import com.sjj.mashibing.tank.util.ConfigUtil;

/**
 * 接口功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/16
 */
public interface Constants {
    String LINE_SEPERATOR = System.getProperty("line.separator");
    int GAME_WIDTH = ConfigUtil.getInt("frame.main.width");
    int GAME_HEIGHT = ConfigUtil.getInt("frame.main.height");
}
