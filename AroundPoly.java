package poly;

import java.util.List;
import java.util.ArrayList;

public class AroundPoly {
				/**
				 * 左旋递归，从一个点开始遍历，当遍历到交点时，则切换到另一个多边形反向遍历。直至最初点时跳出。
				 * @param fPoly
				 * @param sPoly
				 * @param newPoly
				 * @param index
				 * @param num
				 */
	
				public static void aroundAntiClockWise(Poly fPoly,Poly sPoly,Poly newPoly,int index,int num) {
					for(int i = index;;){
						   if(i==fPoly.size()) i=0;
						   if(i<0) i=fPoly.size()-1;
						   if((fPoly.points.get(i).isEndFlag()==false&&fPoly.points.get(i).isErgodic()==false)||(fPoly.points.get(i).isEndFlag()==true&&fPoly.points.get(i).isErgodic()==false)) {
							   if(fPoly.points.get(i).isCrossPoint()==false||fPoly.points.get(i).isEndFlag()==true) {
								   newPoly.points.add(fPoly.points.get(i));
							   }else {
								   	index = Util.indexOfPoly(sPoly, fPoly.points.get(i));
								   	newPoly.points.add(fPoly.points.get(i));
								   	fPoly.points.get(i).setErgodic(true);
								   	sPoly.points.get(index).setErgodic(true);
								   	num++;
								   	aroundAntiClockWise(sPoly, fPoly, newPoly, index,num);
								   	return;
							}
						   }else if(fPoly.points.get(i).isErgodic()==true&&fPoly.points.get(i).isEndFlag()==true){
							   return;
						   }
						   fPoly.points.get(i).setErgodic(true);
						   if(num%2==0) {
							   i--;
						   }else {
							i++;
						}
					   }
				}
				/**
				 * 从一个多边形的外点(不在另一个多边形内的点)依次按点左旋得到所有的多边形
				 * @param aPoly
				 * @param bPoly
				 * @return
				 */
				public static List<Poly> aroundAllPoly(Poly aPoly,Poly bPoly) {
					List<Poly> newPolyList = new ArrayList<>();
					aPoly.resetPointFlags();
					int index =Util.setFirst(aPoly,bPoly);
					int k=0;
					for(int i =index;i<aPoly.size();i++) {
						if(i == aPoly.size()) i=0;
						if(aPoly.points.get(i).isEndFlag==true&&aPoly.points.get(i).isErgodic==true) return newPolyList;
						if(aPoly.points.get(i).isCrossPoint) k++;
						if(aPoly.points.get(i).isEndFlag==true||(k%2==0&&k!=0&&aPoly.points.get(i).isErgodic==false)) {
							Poly newPoly = new Poly();
							System.out.println(i);
							aPoly.points.get(i).isEndFlag=true;
  						   aroundAntiClockWise(aPoly, bPoly, newPoly, i, 1);
						   newPolyList.add(new Poly(newPoly));
						}
					}
					return newPolyList;
				}

}
