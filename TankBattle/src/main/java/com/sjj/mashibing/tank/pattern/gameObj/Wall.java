package com.sjj.mashibing.tank.pattern.gameObj;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.IOException;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/9
 */
@Data
@NoArgsConstructor
public class Wall extends GameObject {

    public Wall(int x,int y, int w, int h) {
        super();
        setX(x);
        setY(y);
        setW(w);
        setH(h);

        updateRect();
    }

    @Override
    public void paint(Graphics g) throws IOException {
        Color c = g.getColor();
        g.setColor(Color.gray);
        g.fillRect(getX(), getY(), getW(), getH());
        g.setColor(c);
    }

    public void updateRect(){
        getRect().x = getX();
        getRect().y = getY();
        getRect().width = getW();
        getRect().height = getH();
    }
}
