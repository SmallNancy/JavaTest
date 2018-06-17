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
		
        new PaintThread().start();//开启线程
		addWindowListener(new WindowAdapter() {
			//关闭窗口
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
	}



class PaintThread extends Thread{
	public void run() {
		while(true) {
			repaint();//重画
			try {
				Thread.sleep(60);     //1s=1000ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}

}