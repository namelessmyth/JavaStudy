package com.sjj.mashibing.tank.util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtil {
    /**
     * 旋转图片方法
     *
     * @param bufferedimage 要旋转的图片
     * @param degree 旋转角度，例如：90°，180°，顺时针方向旋转。例如：如果传进来的是朝上的，90之后是朝右。
     * @return 旋转之后的图片
     */
    public static BufferedImage rotateImage(final BufferedImage bufferedimage,
                                            final int degree) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }
}
