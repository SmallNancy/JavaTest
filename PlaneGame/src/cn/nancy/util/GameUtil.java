package cn.nancy.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * 游戏中的工具类
 * @author nancy
 *
 */

public class GameUtil {
	private GameUtil() {
	}
	/**
	 * 加载一张图片首先指定文件路径
	 * 路径读入图片变量中
	 * @param path 图片的路径
	 * @return 返回一个图片
	 */
	public static Image getImage(String path) {
		BufferedImage bImage = null;
		try {
			URL u = GameUtil.class.getClassLoader().getResource(path);
			bImage = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bImage;
	}
}
