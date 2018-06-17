package cn.nancy.plane;

import java.awt.Graphics;
import java.awt.Image;

import cn.nancy.util.GameUtil;

public class Explode {
	double x,y;
	static Image[] images = new Image[16];
	int count;
	static {
		for (int i = 0; i < 16; i++) {
			images[i] = GameUtil.getImage("images/explode/e"+(i+1)+".gif");
			images[i].getWidth(null);
		}
	}
	public void draw(Graphics g) {
		if (count<16) {
			g.drawImage(images[count],(int)x,(int)y, null);
			count++;
		}
		
	}
	
	//创建一个爆炸对象,写构造器
	public Explode(double x,double y) {
		this.x = x;
		this.y = y;
	}

}
