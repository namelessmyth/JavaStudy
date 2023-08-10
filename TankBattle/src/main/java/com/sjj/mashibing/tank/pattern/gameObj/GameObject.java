package com.sjj.mashibing.tank.pattern.gameObj;

import lombok.Data;
import lombok.ToString;

import java.awt.*;
import java.io.IOException;
import java.util.UUID;

/**
 * 游戏对象的公共父类<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/9
 */
@Data
@ToString
public abstract class GameObject {
    private UUID id = UUID.randomUUID();
    private UUID playerId;
    /**
     * 坐标，长，宽
     */
    private int x, y, w, h;
    /**
     * 老的坐标，长宽。用于back方法
     */
    private int xo, yo, wo, ho;
    /**
     * 判断字段是否活着（超出边界）
     */
    private boolean living = true;
    /**
     * 对象长方形，用于碰撞检测
     */
    private Rectangle rect = new Rectangle();

    public abstract void paint(Graphics g) throws IOException;
}
