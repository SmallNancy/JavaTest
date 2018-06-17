package cn.nancy.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * 加载资源文件的工具类
 * @author nancy
 *
 */
public class GameUtil {
	
	private GameUtil() {
	}
	//工具类私有
	public static Image getImage(String path) {
		URL u = GameUtil.class.getClassLoader().getResource(path);
		BufferedImage img = null;
		try {
			img = ImageIO.read(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}

}
