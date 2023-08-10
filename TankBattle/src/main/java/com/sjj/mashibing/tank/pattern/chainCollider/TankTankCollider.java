package com.sjj.mashibing.tank.pattern.chainCollider;

import com.sjj.mashibing.tank.pattern.gameObj.Bullet;
import com.sjj.mashibing.tank.pattern.gameObj.GameObject;
import com.sjj.mashibing.tank.pattern.gameObj.Tank;
import com.sjj.mashibing.tank.pattern.gameObj.Wall;

/**
 * 坦克和坦克相撞实现类<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/9
 */
public class TankTankCollider implements Collider {
    /**
     * 子弹撞墙就die
     * @param go1
     * @param go2
     */
    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if (go1.isLiving() && go2.isLiving() && go1 != go2) {
            //2辆坦克必须存活，且不能是同一辆
            if (go1 instanceof Tank && go2 instanceof Tank) {
                if (go1.getRect().intersects(go2.getRect())) {
                    ((Tank) go1).back();
                }
            }
        }
        return true;
    }
}
