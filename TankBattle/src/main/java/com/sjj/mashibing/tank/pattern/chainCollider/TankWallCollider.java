package com.sjj.mashibing.tank.pattern.chainCollider;

import com.sjj.mashibing.tank.pattern.gameObj.Bullet;
import com.sjj.mashibing.tank.pattern.gameObj.GameObject;
import com.sjj.mashibing.tank.pattern.gameObj.Tank;
import com.sjj.mashibing.tank.pattern.gameObj.Wall;

/**
 * 坦克和墙相撞-实现类<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/9
 */
public class TankWallCollider implements Collider{
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if (go1.isLiving() && go2.isLiving()) {
            if (go1 instanceof Tank && go2 instanceof Wall) {
                if (go1.getRect().intersects(go2.getRect())) {
                    ((Tank) go1).back();
                }
            } else if (go1 instanceof Wall && go2 instanceof Tank) {
                collide(go2, go1);
            }
        }
        return true;
    }
}
