package cn.nancy.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.nancy.util.GameUtil;

//planet 小行星
public class planet extends Star {
	//除了图片坐标，行星沿着椭圆运行：长轴、短轴、速度、star、角度
	double longAxis;  // 长轴
	double shortAxis;  //短轴
	double speed;     //速度
	double degree;
	Star center;      //中心恒星
	boolean satelites; //卫星
	
	
	//重写画图方法
	public void draw(Graphics g) {
		//g.drawImage(img, (int)x, (int)y, null);
		super.draw(g);
		move();
		if (!satelites) {
			drawTrace(g);
		}
		
	}
	
	//画椭圆轨迹
	public void drawTrace(Graphics g) {
		double ovalX,ovalY,ovalWidth,ovalHeight;
		
		ovalWidth = longAxis*2;
		ovalHeight = shortAxis*2;
		ovalX = (center.x + center.width/2) - longAxis;
		ovalY = (center.y + center.height/2) - shortAxis;
		Color c = g.getColor();
		g.setColor(Color.BLUE);
		g.drawOval((int)ovalX, (int)ovalY, (int)ovalWidth, (int)ovalHeight);
		g.setColor(c);
	}
	
	public void move() {
		//沿着椭圆轨迹飞行
		x = center.x + longAxis * Math.cos(degree);
		y = center.y + shortAxis * Math.sin(degree);
		degree += speed;
	}
	
	//构造器
	public planet (Image img,double x,double y) {
		super(img,x,y);
	}
	public planet(Star center,String imgpath,double longAxis, double shortAxis, double speed,boolean satelites) {
		this(center, imgpath, longAxis, shortAxis, speed);
		this.satelites = satelites;
	}

	public planet(Star center,String imgpath,double longAxis, double shortAxis, double speed) {
		super();
		this.center = center;
		this.x = (center.x+center.width) + longAxis;
		this.y = (center.y);
		this.img = GameUtil.getImage(imgpath);
		
		
		this.longAxis = longAxis;
		this.shortAxis = shortAxis;
		this.speed = speed;
		
	}

	public planet(String imgpath, double x, double y) {
		super(imgpath, x, y);
		// TODO Auto-generated constructor stub
	}
}
