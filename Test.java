package poly;

import java.util.List;
import java.awt.Frame;
import java.util.ArrayList;

public class Test {
		public static void main(String[] args) {
//	        //��һ�����Զ����
//			Point a1 = new Point(100, 100);
//			Point a2 = new Point(100, 200);
//			Point a3 = new Point(200, 220);
//			Point a4 = new Point(200, 150);
//			Point a5 = new Point(250, 130);
//			Point a6 = new Point(250, 230);
//			Point a7 = new Point(300, 200);
//			Point a8 = new Point(300, 80);
//			 //�ڶ������Զ����
//			Point b1 = new Point(30, 170);
//			Point b2 = new Point(150, 190);
//			Point b3 = new Point(230, 200);
//			Point b4 = new Point(350, 180);
//			Point b5 = new Point(350, 160);
//			Point b6 = new Point(230, 165);
	        //��һ�����Զ����
			Point a1 = new Point(100, 400);
			Point a2 = new Point(200, 500);
			Point a3 = new Point(200, 600);
			Point a4 = new Point(500, 600);
			Point a5 = new Point(500, 500);
			Point a6 = new Point(300, 500);
			Point a7 = new Point(300, 400);
			Point a8 = new Point(500, 400);
			Point a9 = new Point(500, 300);
			Point a10 = new Point(200, 300);
			 //�ڶ������Զ����
			Point b1 = new Point(150, 600);
			Point b2 = new Point(400, 700);
			Point b3 = new Point(400, 450);
			Point b4 = new Point(400, 200);
			Point b5 = new Point(300, 200);


			//�������㼯��
			List<Point> aList = new ArrayList<>();
			List<Point> bList = new ArrayList<>();
//			aList.add(a1);aList.add(a2);aList.add(a3);aList.add(a4);aList.add(a5);aList.add(a6);aList.add(a7);aList.add(a8);
//			bList.add(b1);bList.add(b2);bList.add(b3);bList.add(b4);bList.add(b5);bList.add(b6);
			aList.add(a1);aList.add(a2);aList.add(a3);aList.add(a4);aList.add(a5);aList.add(a6);aList.add(a7);aList.add(a8);aList.add(a9);aList.add(a10);
			bList.add(b1);bList.add(b2);bList.add(b3);bList.add(b4);bList.add(b5);
			//���㼯���뵽�������
			Poly aPoly = new Poly(aList);
			Poly bPoly = new Poly(bList);
			//�ڶ�����в��뽻��
			updatePoly.addCrossPoint(aPoly, bPoly);
			updatePoly.addCrossPoint(bPoly, aPoly);
			
			//
			aPoly.printPoly();
			bPoly.printPoly();
			//������������Ķ����
			List<Poly> aNewPoly = new ArrayList<>();
			List<Poly> bNewPoly = new ArrayList<>();
			
			//���������
			aNewPoly = AroundPoly.aroundAllPoly(aPoly, bPoly);
			aPoly.resetPointFlags();
			bNewPoly = AroundPoly.aroundAllPoly(bPoly, aPoly);
			
			//������η���һ������μ���
			List<Poly> tNewPoly = new ArrayList<>();
			tNewPoly.addAll(aNewPoly);
			tNewPoly.addAll(bNewPoly);
			
			//������κ��������Ķ����
			PolyFrame my = new PolyFrame();
			my.aPoly = aPoly;
			my.bPoly = bPoly;
			my.newPoly=tNewPoly;
			my.launchFrame();
		}
}
