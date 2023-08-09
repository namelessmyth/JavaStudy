package com.sjj.mashibing.tank.pattern.chain;

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
    public void collide(GameObject go1, GameObject go2) {
        if (go1 instanceof Tank && go2 instanceof Bullet) {
            ((Bullet) go2).collideWith((Tank) go1);
        } else if (go1 instanceof Bullet && go2 instanceof Tank) {
            ((Bullet) go1).collideWith((Tank) go2);
        }
    }
}
