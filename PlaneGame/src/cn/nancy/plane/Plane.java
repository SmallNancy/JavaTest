package cn.nancy.plane;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * 2D游戏碰撞检测基于矩形3D游戏基于立方体
 */
import cn.nancy.util.GameUtil;

public class Plane extends GameObject {
	private boolean left,up,down,right;
	private boolean live = true;
	
//	//获得飞机的宽度和高度
//	public Rectangle getRect() {
//		Rectangle rectangle = new Rectangle((int)x, (int)y, width, height);
//		return rectangle;
//		
//	}
	public void draw(Graphics g) {
		if (live) {
			g.drawImage(img, (int)x, (int)y, null);
			move();
		}
	}
	
	public void move() {
		if (left) {
			x -= speed;
		}
		if (down) {
			y += speed;
		}
		if (right) {
			x += speed;
		}
		if (up) {
			y -= speed;
		}
		
	}
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;

		default:
			break;
		}
	}
	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down =false;
			break;

		default:
			break;
		}
	}
	
	public Plane(String imgpath,double x,double y) {
		super();
		this.img = GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	public Plane() {
		
	}

	public boolean isLive() {
		return live;
	}

	public void setLive(boolean live) {
		this.live = live;
	}
 
}
