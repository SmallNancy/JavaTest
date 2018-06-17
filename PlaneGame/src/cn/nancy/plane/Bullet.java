package cn.nancy.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import cn.nancy.util.Constant;

public class Bullet extends GameObject{
	double degree;//随机

	
	public Bullet() {
		// TODO Auto-generated constructor stub
		degree = Math.random()*Math.PI*2;
		x = Constant.GAME_WIDTH/2;
		y = Constant.GAME_HIGHT/2;
		//0-2pi之间的数
		width = 10;
		height = 10;
	}
	public void draw(Graphics g) {
		Color color = g.getColor();
		g.setColor(Color.YELLOW);
		g.fillOval((int)x, (int)y, width, height);
		
		x += speed*Math.cos(degree);
		y += speed*Math.sin(degree);
		
		if (x < 0||x>Constant.GAME_WIDTH - width) {
			degree = Math.PI-degree;
		}
		if (y < 30||y>Constant.GAME_HIGHT - height) {
			degree = - degree;
		}
		g.setColor(color);
	}

}
