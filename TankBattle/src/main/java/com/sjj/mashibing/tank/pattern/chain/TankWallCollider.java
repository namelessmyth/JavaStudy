package com.sjj.mashibing.tank.pattern.chain;

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
    public void collide(GameObject go1, GameObject go2) {
        if (go1 instanceof Tank && go2 instanceof Wall) {
            ((Tank) go1).collideWith((Wall) go2);
        } else if (go1 instanceof Wall && go2 instanceof Tank) {
            ((Tank) go2).collideWith((Wall) go1);
        }
    }
}
