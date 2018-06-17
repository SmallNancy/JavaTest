package cn.nancy.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.nancy.util.GameUtil;

public class Star {
	Image img;
	double x,y;
	int width,height;
	
	public void draw(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	}
	
	public Star() {
		
	}
	public Star(Image img) {
		this.img = img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	
	}
	
	public Star(Image img,double x,double y){
		this(img);
		this.x = x;
		this.y = y;
		
	}
	//写一个构造器，传相关参数
	public Star(String imgpath,double x,double y) {
		this.img = GameUtil.getImage(imgpath); //通过this调用另一个构造器，避免代码重复
		this.x = x;
		this.y = y;
	}
}
