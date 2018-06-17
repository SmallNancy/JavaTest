package poly;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;


public class PolyFrame extends MyFrame{
		Poly aPoly;
		Poly bPoly;
		List<Poly> newPoly = new ArrayList<>();
		/**
		 * ����λ���
		 */
		public void paint(Graphics g) {
			if(aPoly.size()>0&&bPoly.size()>0){
				Color c = g.getColor();
				g.setColor(Color.red);
				/*
				 * ��һ������Σ���ɫ
				 */
			for(int i = 0;i<aPoly.size()-1;i++){
				g.drawLine((int)aPoly.points.get(i).getX(), (int)aPoly.points.get(i).getY(), (int)aPoly.points.get(i+1).getX(), (int)aPoly.points.get(i+1).getY());
			}
			g.drawLine((int)aPoly.points.get(aPoly.size()-1).getX(), (int)aPoly.points.get(aPoly.size()-1).getY(), (int)aPoly.points.get(0).getX(), (int)aPoly.points.get(0).getY());
			/*
			 * �ڶ�������Σ���ɫ
			 */
			g.setColor(Color.blue);
			for(int i = 0;i<bPoly.size()-1;i++){
				g.drawLine((int)bPoly.points.get(i).getX(), (int)bPoly.points.get(i).getY(), (int)bPoly.points.get(i+1).getX(), (int)bPoly.points.get(i+1).getY());
			}
			g.drawLine((int)bPoly.points.get(bPoly.size()-1).getX(), (int)bPoly.points.get(bPoly.size()-1).getY(), (int)bPoly.points.get(0).getX(), (int)bPoly.points.get(0).getY());
			/*
			 * �����Ķ������䣬��ɫ
			 */
			g.setColor(Color.gray);
			for(int i = 0;i<newPoly.size();i++) {
				Polygon polygon = new Polygon();
				for(int j =0;j<newPoly.get(i).size();j++ ) {
					polygon.addPoint((int)newPoly.get(i).points.get(j).getX(),(int)newPoly.get(i).points.get(j).getY());
				}
				g.fillPolygon(polygon);
			}
			g.setColor(c);
		}
}
}
