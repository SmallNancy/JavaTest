package cn.nancy.plane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import cn.nancy.util.Constant;
import cn.nancy.util.GameUtil;
import cn.nancy.util.MyFrame;

public class PlaneGameFrame extends MyFrame{
	
	//加载两张图片
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane plane = new Plane("images/plane.png", 50, 50);
	
	ArrayList bulletList = new ArrayList();//保存子弹的数组
	Date startTime;
	Date endTime;
	Explode blast;
	
	//画出来
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		plane.draw(g);
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = (Bullet)bulletList.get(i);
			bullet.draw(g);
			
			//检测飞机碰撞
			boolean crash = bullet.getRec().intersects(plane.getRec());
			if (crash) {
				plane.setLive(false);
				if(blast==null) {
					endTime = new Date();
					blast = new Explode(plane.x, plane.y);
				}
				blast.draw(g);
				break;
			}
			if (!plane.isLive()) {
				printInfo(g, "GAME OVER",0, 100,100,Color.white);
				int period = (int)(endTime.getTime()-startTime.getTime())/1000;
				printInfo(g, "生存时间"+period+"秒", 20, 150, 160, Color.white);
				switch (period/10) {
				case 0:
				case 1:
					printInfo(g, "小小鸟", 50,100,200, Color.white);
					break;
				case 2:
					printInfo(g, "大神", 50,100,200, Color.white);
					break;

				default:
					printInfo(g, "你最棒！", 50,100,200, Color.white);
					break;
				}
			}
			
			//printInfo(g, "分数：",100,15,10,45,Color.YELLOW);
			
		}
	}
	/**
	 * 窗口信息打印
	 * @param g 画笔
	 * @param str 信息显示
	 * @param size 字体大小
	 */
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color) {
			Color c = g.getColor();
			g.setColor(color);
			Font f = new Font("宋体", Font.BOLD, size);
			g.setFont(f);
			g.drawString(str, x, y);
			g.setColor(c);
	}
	
	
	//new一个游戏窗口
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	
	public void launchFrame() {
		super.launchFrame();
		//增加键盘监听
		addKeyListener(new KeyMonitor());
		
		//生成子弹
		for (int i = 0; i < Constant.COUNTBULLET; i++) {
			Bullet bullet = new Bullet();
			bulletList.add(bullet);
		}
		startTime = new Date();
	}
	
	/**
	 * 定义一个内部类，可以方便的调用外部类的普通属性
	 * @author nancy
	 *
	 */
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub 每一个键代表一个数
			System.out.println("press down " + e.getKeyCode());
			plane.addDirection(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println("released " + e.getKeyCode());
			plane.minusDirection(e);
		}
		
	}
	
}
