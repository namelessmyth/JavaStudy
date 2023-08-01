package com.sjj.mashibing.tank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 坦克类<br>
 * @version 1.0
 * @date 2023/7/31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tank {
    private int x = 100;
    private int y = 100;
    private final int SPEED = 5;
    private Direction dir = Direction.DOWN;

    /**
     * 覆盖此方法后，会在frame创建时就执行。
     * @param g
     */
    public void paint(Graphics g) {
        g.fillRect(x, y, 50, 50);
    }

    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        switch (keycode) {
            case KeyEvent.VK_LEFT:
                dir = Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                dir = Direction.RIGHT;
                break;
            case KeyEvent.VK_UP:
                dir = Direction.UP;
                break;
            case KeyEvent.VK_DOWN:
                dir = Direction.DOWN;
                break;
            default:
                break;
        }
        move();
    }

    public void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
    }
}
