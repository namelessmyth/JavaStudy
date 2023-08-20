package com.sjj.mashibing.tank.netty.strategy;


import com.sjj.mashibing.tank.netty.TankClient;
import com.sjj.mashibing.tank.netty.TankFrame;
import com.sjj.mashibing.tank.netty.gameObj.Bullet;
import com.sjj.mashibing.tank.netty.gameObj.TankPlayer;
import com.sjj.mashibing.tank.netty.msg.BulletMsg;

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
        TankFrame.INSTANCE.getGm().add(b);
        TankClient.send(new BulletMsg(b));
    }
}
