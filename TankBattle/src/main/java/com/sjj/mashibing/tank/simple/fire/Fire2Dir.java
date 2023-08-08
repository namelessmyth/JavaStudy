package com.sjj.mashibing.tank.simple.fire;

import com.sjj.mashibing.tank.domain.Bullet;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.simple.TankFrame;
import com.sjj.mashibing.tank.simple.TankPlayer;

/**
 * 往2个方向开火<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/8
 */
public class Fire2Dir implements FireStrategy{
    @Override
    public void fire(TankPlayer tank) {
        //根据坦克坐标计算子弹坐标，使子弹出现在坦克中部。
        int bX = tank.getX() + TankPlayer.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + TankPlayer.HEIGHT / 2 - Bullet.HEIGHT / 2;
        TankFrame.INSTANCE.bullets.add(new Bullet(tank.getId(), bX, bY, tank.getDir(), tank.getGroup(), null));
        TankFrame.INSTANCE.bullets.add(new Bullet(tank.getId(), bX, bY, tank.getDir().getOpposite(), tank.getGroup(), null));
    }
}
