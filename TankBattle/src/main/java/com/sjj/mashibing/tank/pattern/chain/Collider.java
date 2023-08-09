package com.sjj.mashibing.tank.pattern.chain;

import com.sjj.mashibing.tank.pattern.gameObj.GameObject;

/**
 * 接口功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/9
 */
public interface Collider {
    void collide(GameObject go1, GameObject go2);
}
