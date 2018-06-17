package cn.nancy.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * 窗口设置类
 * @author nancy
 *
 */

public class MyFrame extends Frame {
	//创建一个窗口，设置窗口大小、位置、可见性
	public void launchFrame() {
		setTitle("飞机大战游戏");
		setLocation(100, 200);
		setSize(Constant.GAME_WIDTH, Constant.GAME_HIGHT);
		setVisible(true);
		
		
		new PaintThread().start();
		//关闭窗口
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	/**
	 * 重画线程类
	 * @author nancy
	 *
	 */
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();//重画
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	 /*
     * 双缓冲解决屏幕闪烁
     */
    private Image offScreenImage = null;
    public void update(Graphics g) {
		if(offScreenImage==null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HIGHT);
		Graphics goff = offScreenImage.getGraphics();
		
		paint(goff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

}
