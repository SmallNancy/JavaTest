package poly;

import java.util.ArrayList;
import java.util.List;

public class updatePoly {
	/**
	 * 将交点加入要多边形的点集中
	 * @param poly1
	 * @param poly2
	 */
		public static void addCrossPoint(Poly poly1,Poly poly2) {
			List<Point> cpPoints = new ArrayList<Point>();
			for(int i=0;i<poly1.size()-1;i++) {
				for(int j= 0;j<poly2.size()-1;j++) {
					if(Util.isHaveCrossPoint(poly1.points.get(i), poly1.points.get(i+1), poly2.points.get(j), poly2.points.get(j+1))) {
						cpPoints.add(Util.GetCrossPoint(poly1.points.get(i), poly1.points.get(i+1), poly2.points.get(j), poly2.points.get(j+1)));	
					}
				}
				if(Util.isHaveCrossPoint(poly1.points.get(i), poly1.points.get(i+1), poly2.points.get(poly2.size()-1), poly2.points.get(0))) {
					cpPoints.add(Util.GetCrossPoint(poly1.points.get(i), poly1.points.get(i+1), poly2.points.get(poly2.size()-1), poly2.points.get(0)));	
				}
				if(cpPoints.size()>=2) {
					Util.sortListPoint(cpPoints, poly1.points.get(i));
					for(int k = 0;k<cpPoints.size();k++) {
						poly1.points.add(i+k+1, cpPoints.get(k));
					}
					i+=cpPoints.size();
					cpPoints.clear();
				}else if(cpPoints.size()>0){
					poly1.points.add(i+1, cpPoints.get(0));
					i++;
					cpPoints.clear();
				}
			}
			for(int j= 0;j<poly2.size()-1;j++) {
				if(Util.isHaveCrossPoint(poly1.points.get(poly1.size()-1), poly1.points.get(0), poly2.points.get(j), poly2.points.get(j+1))) {
					cpPoints.add(Util.GetCrossPoint(poly1.points.get(poly1.size()-1), poly1.points.get(0), poly2.points.get(j), poly2.points.get(j+1)));	
				}
			}
			if(Util.isHaveCrossPoint(poly1.points.get(poly1.size()-1), poly1.points.get(0), poly2.points.get(poly2.size()-1), poly2.points.get(0))) {
				cpPoints.add(Util.GetCrossPoint(poly1.points.get(poly1.size()-1), poly1.points.get(0), poly2.points.get(poly2.size()-1), poly2.points.get(0)));	
			}
			if(cpPoints.size()>=2) {
				Util.sortListPoint(cpPoints, poly1.points.get(poly1.size()-1));
				for(int k = 0;k<cpPoints.size();k++) {
					poly1.points.add(cpPoints.get(k));
				}
			}else if(cpPoints.size()>0){
				poly1.points.add(cpPoints.get(0));
			}
			poly1.updateEdges();
		}
		/**
		 * 删除多边形中重复的点
		 * @param poly
		 */
		public static void deleteRepPoint(Poly poly) {
			for(int i =0;i<poly.size()-1;i++)
			{
				if(Util.isEqualPoint(poly.points.get(i), poly.points.get(i+1)))
				{
					poly.points.remove(i);
					i--;
				}
			}
			while ((Util.isEqualPoint(poly.points.get(poly.size()), poly.points.get(0))) ) {
				poly.points.remove(poly.size()-1);		
			}
			poly.updateEdges();
		}
		/**
		 * 遍历第一个多边形的点，如果该点在另一个多边形里面，将其状态改为true
		 * @param aPoly
		 * @param bPoly
		 */
		
		public static void setPointInAnotherPolyFlag(Poly aPoly,Poly bPoly) {
			for(int i= 0;i<aPoly.size();i++) {
				if(Util.IsPointInPolygon(bPoly, aPoly.points.get(i))) {
					aPoly.points.get(i).setInAnotherPoly(true);
				}
			}
		}
		
}
