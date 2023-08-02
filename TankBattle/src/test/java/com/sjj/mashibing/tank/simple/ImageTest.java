package com.sjj.mashibing.tank.simple;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sjj.mashibing.tank.util.ImageUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ImageTest {

	@Test
	void readTest() {
		try {
			BufferedImage image = ImageIO.read(new File("D:\\Workspace\\idea\\mashibing\\mashibing\\TankBattle\\src\\main\\resources\\images\\bulletD.gif"));
			assertNotNull(image);
			
			BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			//this.getClass()
			assertNotNull(image2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testRotate() {
		try {
			BufferedImage tankL = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankL = ImageUtil.rotateImage(tankL, 90);
			Assertions.assertNotNull(tankL);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
