package com.sjj.mashibing.tank.pattern;

import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.pattern.chainCollider.CollideChain;
import com.sjj.mashibing.tank.pattern.gameObj.GameObject;
import com.sjj.mashibing.tank.pattern.gameObj.Tank;
import com.sjj.mashibing.tank.pattern.gameObj.TankPlayer;
import com.sjj.mashibing.tank.pattern.gameObj.Wall;
import com.sjj.mashibing.tank.util.ConfigUtil;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 封装所有游戏的model对象-让View层不用和每个Model直接对接<br>
 * 设计模式-门面模式-中介者模式<br>
 * @author namelessmyth
 * @version 1.0
 * @date 2023/8/9
 */
@Data
@Slf4j
@ToString
public class GameModel implements Serializable {
    private static final long serialVersionUID = -8488675236010379054L;
    public static final int ENEMY_SIZE = ConfigUtil.getInt("tank.enemy.size");

    TankPlayer myTank;
    List<GameObject> objects;
    CollideChain collideChain = new CollideChain();

    public GameModel() {
        initGameObjects();
    }

    private void initGameObjects() {
        objects = new ArrayList<>();

        myTank = new TankPlayer(TankFrame.GAME_WIDTH / 2 - 100, TankFrame.GAME_HEIGHT - 70, Dir.UP, Group.GOOD);
        add(myTank);

        int gap = TankFrame.GAME_WIDTH / ENEMY_SIZE;
        for (int i = 0; i < ENEMY_SIZE; i++) {
            Tank tank = new Tank(gap * i, 30, Dir.DOWN, Group.BAD);
            add(tank);
        }
        add(new Wall(300, 300, 240, 40));
    }

    public void paint(Graphics g) {
        try {
            Color c = g.getColor();
            g.setColor(Color.WHITE);
            g.drawString("objects: " + objects.size(), 10, 45);
            g.setColor(c);

            for (int i = 0; i < objects.size(); i++) {
                GameObject go = objects.get(i);
                if (!go.isLiving()) {
                    //如果在上一次碰撞中已经die则不处理。
                    continue;
                }
                for (int i1 = i + 1; i1 < objects.size(); i1++) {
                    GameObject go1 = objects.get(i1);
                    if (!collideChain.collide(go, go1)) {
                        break;
                    }
                }
                go.paint(g);
            }
        } catch (IOException e) {
            log.error("TankFrame绘制异常：", e);
        }
    }

    public void add(GameObject go) {
        objects.add(go);
    }

    public void remove(GameObject go) {
        objects.remove(go);
    }
}
