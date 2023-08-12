package com.sjj.mashibing.tank.pattern.chainCollider;

import com.sjj.mashibing.tank.pattern.gameObj.GameObject;

import java.io.Serializable;

/**
 * 接口功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/9
 */
public interface Collider extends Serializable {
    /**
     * 碰撞方法
     * @param go1
     * @param go2
     * @return true：代表还要继续执行，false：代表不用继续碰撞下去了。
     */
    boolean collide(GameObject go1, GameObject go2);
}
