package cn.nancy.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * ����������
 * @author nancy
 *
 */

public class MyFrame extends Frame {
	//����һ�����ڣ����ô��ڴ�С��λ�á��ɼ���
	public void launchFrame() {
		setTitle("�ɻ���ս��Ϸ");
		setLocation(100, 200);
		setSize(Constant.GAME_WIDTH, Constant.GAME_HIGHT);
		setVisible(true);
		
		
		new PaintThread().start();
		//�رմ���
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
	}
	
	/**
	 * �ػ��߳���
	 * @author nancy
	 *
	 */
	class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();//�ػ�
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
     * ˫��������Ļ��˸
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
