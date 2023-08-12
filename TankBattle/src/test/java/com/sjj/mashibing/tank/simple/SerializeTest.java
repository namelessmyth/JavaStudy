package com.sjj.mashibing.tank.simple;

import cn.hutool.core.util.SerializeUtil;
import com.sjj.mashibing.tank.domain.Dir;
import com.sjj.mashibing.tank.domain.Group;
import com.sjj.mashibing.tank.util.ImageUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 序列化测试类
 */
class SerializeTest {
	@Test
	void testSerializeUtil() {
		Tank t = new Tank(100, 30, null, null, null);
		byte[] ba = SerializeUtil.serialize(t);
		t = SerializeUtil.deserialize(ba, Tank.class);
		System.out.println(t);
	}
}
