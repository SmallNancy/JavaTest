package cn.nancy.solar;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import cn.nancy.util.GameUtil;

//planet С����
public class planet extends Star {
	//����ͼƬ���꣬����������Բ���У����ᡢ���ᡢ�ٶȡ�star���Ƕ�
	double longAxis;  // ����
	double shortAxis;  //����
	double speed;     //�ٶ�
	double degree;
	Star center;      //���ĺ���
	boolean satelites; //����
	
	
	//��д��ͼ����
	public void draw(Graphics g) {
		//g.drawImage(img, (int)x, (int)y, null);
		super.draw(g);
		move();
		if (!satelites) {
			drawTrace(g);
		}
		
	}
	
	//����Բ�켣
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
		//������Բ�켣����
		x = center.x + longAxis * Math.cos(degree);
		y = center.y + shortAxis * Math.sin(degree);
		degree += speed;
	}
	
	//������
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
