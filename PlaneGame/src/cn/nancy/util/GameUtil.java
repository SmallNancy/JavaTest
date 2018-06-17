package cn.nancy.util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * ��Ϸ�еĹ�����
 * @author nancy
 *
 */

public class GameUtil {
	private GameUtil() {
	}
	/**
	 * ����һ��ͼƬ����ָ���ļ�·��
	 * ·������ͼƬ������
	 * @param path ͼƬ��·��
	 * @return ����һ��ͼƬ
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
