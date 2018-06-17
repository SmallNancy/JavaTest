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
	
	//��������ͼƬ
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane plane = new Plane("images/plane.png", 50, 50);
	
	ArrayList bulletList = new ArrayList();//�����ӵ�������
	Date startTime;
	Date endTime;
	Explode blast;
	
	//������
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		plane.draw(g);
		for (int i = 0; i < bulletList.size(); i++) {
			Bullet bullet = (Bullet)bulletList.get(i);
			bullet.draw(g);
			
			//���ɻ���ײ
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
				printInfo(g, "����ʱ��"+period+"��", 20, 150, 160, Color.white);
				switch (period/10) {
				case 0:
				case 1:
					printInfo(g, "СС��", 50,100,200, Color.white);
					break;
				case 2:
					printInfo(g, "����", 50,100,200, Color.white);
					break;

				default:
					printInfo(g, "�������", 50,100,200, Color.white);
					break;
				}
			}
			
			//printInfo(g, "������",100,15,10,45,Color.YELLOW);
			
		}
	}
	/**
	 * ������Ϣ��ӡ
	 * @param g ����
	 * @param str ��Ϣ��ʾ
	 * @param size �����С
	 */
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color) {
			Color c = g.getColor();
			g.setColor(color);
			Font f = new Font("����", Font.BOLD, size);
			g.setFont(f);
			g.drawString(str, x, y);
			g.setColor(c);
	}
	
	
	//newһ����Ϸ����
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	
	public void launchFrame() {
		super.launchFrame();
		//���Ӽ��̼���
		addKeyListener(new KeyMonitor());
		
		//�����ӵ�
		for (int i = 0; i < Constant.COUNTBULLET; i++) {
			Bullet bullet = new Bullet();
			bulletList.add(bullet);
		}
		startTime = new Date();
	}
	
	/**
	 * ����һ���ڲ��࣬���Է���ĵ����ⲿ�����ͨ����
	 * @author nancy
	 *
	 */
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub ÿһ��������һ����
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
