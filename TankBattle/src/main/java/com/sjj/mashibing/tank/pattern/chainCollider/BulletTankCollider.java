package com.sjj.mashibing.tank.pattern.chainCollider;

import com.sjj.mashibing.tank.pattern.gameObj.Bullet;
import com.sjj.mashibing.tank.pattern.gameObj.Tank;
import com.sjj.mashibing.tank.pattern.gameObj.GameObject;

/**
 * 子弹和坦克相撞实现类<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/9
 */
public class BulletTankCollider implements Collider{
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if (go1 instanceof Tank && go2 instanceof Bullet) {
            return ((Bullet) go2).collideWith((Tank) go1);
        } else if (go1 instanceof Bullet && go2 instanceof Tank) {
            return ((Bullet) go1).collideWith((Tank) go2);
        }
        return true;
    }
}
