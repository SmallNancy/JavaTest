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
			
			
			new PaintThread().start();//�����ػ��߳�
			/*
			 * �رմ���
			 */
			addWindowListener(new WindowAdapter() {
				
				@Override
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
		}

		
	    /*
	     * ˫��������Ļ��˸
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
		 * ����һ���ػ����ڵ��߳��࣬��һ���ڲ���
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


