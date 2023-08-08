package com.sjj.mashibing.tank.domain;

import java.util.Random;

/**
 * 坦克方向类<br>
 *
 * @date 2023/7/31
 */
public enum Dir {
    LEFT, RIGHT, UP, DOWN;
    static Random random = new Random();

    public static Dir random() {
        return values()[random.nextInt(values().length)];
    }

    public Dir getOpposite() {
        Dir d = Dir.UP;
        if (this.name().equals("LEFT")) {
            d = Dir.RIGHT;
        } else if (this.name().equals("RIGHT")) {
            d = Dir.LEFT;
        } else if (this.name().equals("UP")) {
            d = Dir.DOWN;
        } else if (this.name().equals("DOWN")) {
            d = Dir.UP;
        }
        return d;
    }
}
