package com.sjj.mashibing.tank.pattern.strategy;


import com.sjj.mashibing.tank.pattern.gameObj.TankPlayer;

import java.io.Serializable;

/**
 * 策略模式-坦克开火接口<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/8
 */
public interface FireStrategy extends Serializable {
    void fire(TankPlayer tank);
}
