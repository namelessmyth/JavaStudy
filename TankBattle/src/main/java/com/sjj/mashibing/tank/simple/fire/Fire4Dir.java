package com.sjj.mashibing.tank.simple.fire;

import com.sjj.mashibing.tank.domain.Bullet;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.simple.Audio;
import com.sjj.mashibing.tank.simple.TankFrame;
import com.sjj.mashibing.tank.simple.TankPlayer;

/**
 * 往4个方向开火<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/8
 */
public class Fire4Dir implements FireStrategy{
    @Override
    public void fire(TankPlayer tank) {
        //根据坦克坐标计算子弹坐标，使子弹出现在坦克中部。
        int bX = tank.getX() + TankPlayer.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = tank.getY() + TankPlayer.HEIGHT / 2 - Bullet.HEIGHT / 2;
        for (Dir d : Dir.values()) {
            TankFrame.INSTANCE.bullets.add(new Bullet(tank.getId(), bX, bY, d, tank.getGroup(), null));
        }
    }
}
