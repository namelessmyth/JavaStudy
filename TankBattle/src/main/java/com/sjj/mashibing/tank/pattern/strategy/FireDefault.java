package com.sjj.mashibing.tank.pattern.strategy;


import com.sjj.mashibing.tank.pattern.gameObj.Bullet;
import com.sjj.mashibing.tank.pattern.TankFrame;
import com.sjj.mashibing.tank.pattern.gameObj.TankPlayer;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/8
 */
public class FireDefault implements FireStrategy {
    @Override
    public void fire(TankPlayer tank) {
        //根据坦克坐标计算子弹坐标，使子弹出现在坦克中部。
        int bX = tank.getX() + TankPlayer.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + TankPlayer.HEIGHT / 2 - Bullet.HEIGHT / 2;
        Bullet b = new Bullet(tank.getId(), bX, bY, tank.getDir(), tank.getGroup());
        TankFrame.INSTANCE.add(b);
    }
}
