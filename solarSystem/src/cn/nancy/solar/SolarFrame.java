package cn.nancy.solar;

import java.awt.Graphics;
import java.awt.Image;

import cn.nancy.util.Constant;
import cn.nancy.util.GameUtil;
import cn.nancy.util.MyFrame;

/**
 * Ì«ÑôÏµÖ÷´°¿Ú
 * @author Nancy
 *
 */
public class SolarFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	Star sun = new Star("images/sun.jpg", Constant.GAME_WIDTH/2, Constant.GAME_HEIGHT/2);
	planet earth = new planet(sun, "images/Earth.jpg",150,100,0.1);
	planet mars = new planet(sun, "images/Mars.jpg", 180, 120, 0.2);
	planet jupiter = new planet(sun, "images/Jupiter.jpg",240, 130,0.15);
	planet mercury = new planet(sun, "images/Mercury.jpg", 280, 150, 0.3);
	planet neptune = new planet(sun, "images/Neptune.jpg", 300, 165, 0.35);
	planet uranus = new planet(sun, "images/Uranus.jpg", 340, 180, 0.4);
	planet moon = new planet(earth, "images/moon.jpg", 20, 15, 0.3,true);
	planet venus = new planet(sun, "images/Venus.jpg", 360, 200, 0.1);
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		sun.draw(g);
		earth.draw(g);
		mars.draw(g);
		moon.draw(g);
		jupiter.draw(g);
		mercury.draw(g);
		neptune.draw(g);
		uranus.draw(g);
		venus.draw(g);
	}
	public static void main(String[] args) {
		new SolarFrame().launchFrame();
	}
	
    /*
     * Ë«»º³å½â¾öÆÁÄ»ÉÁË¸
     */
    private Image offScreenImage = null;
    public void update(Graphics g) {
		if(offScreenImage==null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		Graphics goff = offScreenImage.getGraphics();
		
		paint(goff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
}
