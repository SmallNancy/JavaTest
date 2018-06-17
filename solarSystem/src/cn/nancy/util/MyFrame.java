package cn.nancy.util;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MyFrame extends Frame{
	
	public void launchFrame() {
		setTitle("MyGame");
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		setLocation(200, 200);
		setVisible(true);
		
        new PaintThread().start();//�����߳�
		addWindowListener(new WindowAdapter() {
			//�رմ���
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}



class PaintThread extends Thread{
	public void run() {
		while(true) {
			repaint();//�ػ�
			try {
				Thread.sleep(60);     //1s=1000ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

}