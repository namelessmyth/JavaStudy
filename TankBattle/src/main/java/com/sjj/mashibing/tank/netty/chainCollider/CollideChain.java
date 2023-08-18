package com.sjj.mashibing.tank.netty.chainCollider;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
import com.sjj.mashibing.tank.netty.gameObj.GameObject;
import com.sjj.mashibing.tank.util.ConfigUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 类功能说明<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/10/0010
 */
@Slf4j
@Data
public class CollideChain implements Collider, Serializable {
    private static final long serialVersionUID = 4969532920556755864L;
    private List<Collider> colliders;

    public CollideChain() {
        super();
        initColliders();
    }

    private void initColliders() {
        String collidersPackage = ConfigUtil.getStr("netty.collider.chain.package",
                "com.sjj.mashibing.tank.netty.chainCollider");
        String collidersClass = ConfigUtil.getStr("object.collider.chain.class");
        if (StrUtil.isNotBlank(collidersClass)) {
            List<String> strs = StrUtil.split(collidersClass, ",");
            colliders = new ArrayList<>(strs.size());
            for (String clazz : strs) {
                colliders.add(ReflectUtil.newInstance(String.join(".", collidersPackage, clazz)));
            }
        }
        log.info("init Collider is over.{}", colliders);
    }

    @Override
    public boolean collide(GameObject go1, GameObject go2) {
        if (CollUtil.isNotEmpty(getColliders())) {
            for (Collider collider : getColliders()) {
                if (!collider.collide(go1, go2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
