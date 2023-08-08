package com.sjj.mashibing.tank.simple.fire;

import com.sjj.mashibing.tank.simple.TankPlayer;

/**
 * 策略模式-坦克开火接口<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/8
 */
public interface FireStrategy {
    void fire(TankPlayer tank);
}
