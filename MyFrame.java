package poly;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
		public void launchFrame() {
			setSize(Constant.WIDTH, Constant.HEIGHT);
			setLocation(200, 200);
			setVisible(true);
			
			
			new PaintThread().start();//启动重画线程
			/*
			 * 关闭窗口
			 */
			addWindowListener(new WindowAdapter() {
				
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		}

		
	    /*
	     * 双缓冲解决屏幕闪烁
	     */
	    private Image offScreenImage = null;
	    public void update(Graphics g) {
			if(offScreenImage==null)
				offScreenImage = this.createImage(Constant.WIDTH,Constant.HEIGHT);
			Graphics goff = offScreenImage.getGraphics();
			
			paint(goff);
			g.drawImage(offScreenImage, 0, 0, null);
		}
		
		/**
		 * 定义一个重画窗口的线程类，是一个内部类
		 * @author Z.M.T
		 *
		 */
		class PaintThread extends Thread{
			public void run() {
				while(true) {
					repaint();
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}
}


