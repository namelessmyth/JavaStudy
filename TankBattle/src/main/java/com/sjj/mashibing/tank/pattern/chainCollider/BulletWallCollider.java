package com.sjj.mashibing.tank.pattern.chainCollider;

import com.sjj.mashibing.tank.pattern.gameObj.Bullet;
import com.sjj.mashibing.tank.pattern.gameObj.GameObject;
import com.sjj.mashibing.tank.pattern.gameObj.Tank;
import com.sjj.mashibing.tank.pattern.gameObj.Wall;

/**
 * 子弹和墙相撞实现类<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/9
 */
public class BulletWallCollider implements Collider {
    /**
     * 子弹撞墙就die
     * @param go1
     * @param go2
     */
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if (go1 instanceof Bullet && go2 instanceof Wall) {
            Bullet b = (Bullet) go1;
            Wall w = (Wall) go2;
            if (b.getRect().intersects(w.getRect())) {
                b.die();
                return false;
            }
        } else if (go1 instanceof Wall && go2 instanceof Bullet) {
            this.collide(go2, go1);
        }
        return true;
    }
}
