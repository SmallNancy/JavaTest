package poly;

import java.util.List;

public class Util {
	/**
	 * 判断点是否在多边形里面
	 * @param poly 判断的多边形
	 * @param pt 判断的点
	 * @return
	 */
	public static boolean IsPointInPolygon(Poly poly,Point pt) {
	    int i,j;
	    boolean c = false;
	    for (i = 0,j = poly.size() - 1;i < poly.size();j = i++)
	    {
	        if ((((poly.points.get(i).getY()<= pt.getY()) && (pt.getY() < poly.points.get(j).getY())) ||
	             ((poly.points.get(j).getY() <= pt.getY()) && (pt.getY() < poly.points.get(i).getY())))
	                && (pt.getX() < (poly.points.get(j).getX() - poly.points.get(i).getX()) * (pt.getY() - poly.points.get(i).getY())/(poly.points.get(j).getY() - poly.points.get(i).getY()) + poly.points.get(i).getX()))
	        {
	            c = !c;
	        }
	    }
	    return c;
	}
	
	/**
	 * 最小值计算
	 * @param a
	 * @param b
	 * @return
	 */
	public static double min(double a, double b){
	    if(a<b) return a;
	    else return b;
	}
	
	/**
	 * 最大值计算
	 * @param a
	 * @param b
	 * @return
	 */
	public static double max(double a, double b){
	    if(a<b) return b;
	    else return a;
	}
	
	/**
	 * 排斥实验
	 * @param p1 第一条边的第一个点
	 * @param p2 第一条边的第二个点
	 * @param q1 第二条边的第一个点
	 * @param q2 第二条边的第二个点
	 * @return
	 */
	public static boolean IsRectCross(final Point p1,final Point p2,final Point q1,final Point q2) {
		boolean ret=min(p1.getX(), p2.getX())<=max(q1.getX(), q2.getX())&&
				min(q1.getX(), q2.getX())<=max(p1.getX(), p2.getX())&&
				min(p1.getY(), p2.getY())<=max(q1.getY(), q2.getY())&&
				min(q1.getY(), q2.getY())<=max(p1.getY(), p2.getY());
		return ret;
	}
	/**
	 * 跨立判断
	 * @param pFirst1 第一条边的第一个点
	 * @param pFirst2 第一条边的第二个点
	 * @param pSecond1 第二条边的第一个点
	 * @param pSecond2 第二条边的第二个点
	 * @return
	 */
	public static boolean IsLineSegmentCross(final Point pFirst1,final Point pFirst2,final Point pSecond1,final Point pSecond2){
	    long line1,line2;
	    line1 = (long) (pFirst1.getX() * (pSecond1.getY() - pFirst2.getY()) +
	            pFirst2.getX() * (pFirst1.getY() - pSecond1.getY()) +
	            pSecond1.getX() * (pFirst2.getY() - pFirst1.getY()));
	    line2 = (long) (pFirst1.getX() * (pSecond2.getY() - pFirst2.getY()) +
	            pFirst2.getX() * (pFirst1.getY() - pSecond2.getY()) +
	            pSecond2.getX() * (pFirst2.getY() - pFirst1.getY()));
	    if (((line1 ^ line2) >= 0) && !(line1 == 0 && line2 == 0))
	        return false;

	    line1 = (long) (pSecond1.getX() * (pFirst1.getY() - pSecond2.getY()) +
	            pSecond2.getX() * (pSecond1.getY() - pFirst1.getY()) +
	            pFirst1.getX() * (pSecond2.getY() - pSecond1.getY()));
	    line2 = (long) (pSecond1.getX() * (pFirst2.getY() - pSecond2.getY()) +
	            pSecond2.getX() * (pSecond1.getY() - pFirst2.getY()) +
	            pFirst2.getX() * (pSecond2.getY() - pSecond1.getY()));
	    if (((line1 ^ line2) >= 0) && !(line1 == 0 && line2 == 0))
	        return false;
	    return true;
	}
	
	/**
	 * 重叠判断
	 * @param p1 第一条边的第一个点
	 * @param p2 第一条边的第二个点
	 * @param q1 第二条边的第一个点
	 * @param q2 第二条边的第二个点
	 * @return
	 */
	public static boolean IsOverlap(final Point p1, final Point p2, final Point q1, final Point q2){
	    if (( p1.getX() -q1.getX() )*( p2.getY()-q1.getY()) -( p2.getX() -q1.getX() )*( p1.getY()-q1.getY())==0&&( p1.getX() -q2.getX() )*( p2.getY()-q2.getY()) -( p2.getX() -q2.getX() )*( p1.getY()-q2.getY())==0)
	    {
	        return true;
	    }else {
	        return false;
	    }
	}
	/**
	 * 求交前的判断
	 * @param a 第一条边的第一个点
	 * @param b 第一条边的第二个点
	 * @param c 第二条边的第一个点
	 * @param d 第二条边的第二个点
	 * @return
	 */
	public static boolean isHaveCrossPoint(final Point a,final Point b,final Point c,final Point d) {
		return IsRectCross(a, b, c, d)&&IsLineSegmentCross(a, b, c, d)&&(!IsOverlap(a, b, c, d));
	}
	
	 /**
	  * 求交点，需通过排斥实验，跨立判断，并且不重叠，则执行
	  * @param p1 第一条边的第一个点
	  * @param p2 第一条边的第二个点
	  * @param q1 第二条边的第一个点
	  * @param q2 第二条边的第二个点
	  * @return
	  */
	public static Point GetCrossPoint(final Point p1,final Point p2,final Point q1,final Point q2)
	{

	    //求交点
		double x,y;
	    double tmpLeft,tmpRight;
	    tmpLeft = (q2.getX() - q1.getX()) * (p1.getY() - p2.getY()) - (p2.getX() - p1.getX()) * (q1.getY() - q2.getY());
	    tmpRight = (p1.getY() - q1.getY()) * (p2.getX() - p1.getX()) * (q2.getX() - q1.getX()) + q1.getX() * (q2.getY() - q1.getY()) * (p2.getX() - p1.getX()) - p1.getX() * (p2.getY() - p1.getY()) * (q2.getX() - q1.getX());

	    x = (double)tmpRight/(double)tmpLeft;

	    tmpLeft = (p1.getX() - p2.getX()) * (q2.getY() - q1.getY()) - (p2.getY() - p1.getY()) * (q1.getX() - q2.getX());
	    tmpRight = p2.getY() * (p1.getX() - p2.getX()) * (q2.getY() - q1.getY()) + (q2.getX()- p2.getX()) * (q2.getY() - q1.getY()) * (p1.getY() - p2.getY()) - q2.getY() * (q1.getX() - q2.getX()) * (p2.getY() - p1.getY());
	    y = (double)tmpRight/(double)tmpLeft;
	    return new Point(x, y,true);
	}
	
/**
 * 点与点之间距离的平方
 * @param p1 第一个点
 * @param p2 第二个点
 * @return
 */
	public static double Distance2(Point p1, Point p2){
	    return (p2.getY()-p1.getY())*(p2.getY()-p1.getY())+(p2.getX()-p1.getX())*(p2.getX()-p1.getX());
	}
	/**
	 * 点距排序，将一个点集中的点按照与另一个点的距离以从小到大的顺序排序
	 * @param aList 点集
	 * @param p 判断的点
	 * @return
	 */

	public static List<Point> sortListPoint(List<Point> aList,Point p) {
		for(int i = 0;i<aList.size();i++) {
			for(int j = 0;j<aList.size()-1-i;j++) {
				if(Distance2(p, aList.get(j))>Distance2(p, aList.get(j+1))) {
				Point temp = new Point(aList.get(j));
				aList.set(j, aList.get(j+1));
				aList.set(j+1, temp);
				}
			}
		}	
		return aList;
	}
	/**
	 * 判断两个点是否相等
	 * @param apPoint 第一个点
	 * @param bpoint 第二个点
	 * @return
	 */
	public static boolean isEqualPoint(Point apPoint,Point bpoint) {
		if((int)apPoint.getX()==bpoint.getX()&&(int)apPoint.getY()==bpoint.getY())
		{
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 找初始在另一个多边形外的点
	 * @param aPoly 第一个多边形
	 * @param bPoly  另一个多边形
	 */
	public static int setFirst(Poly aPoly,Poly bPoly) {
		   for(int i =0;i<aPoly.size();i++) {
			   if(!(Util.IsPointInPolygon(bPoly, aPoly.points.get(i)))) {
				   aPoly.points.get(i).isEndFlag=true;
				   return i;
			   }
		   }
			return -1;
}

	/**
	 * 查找点在多边形的索引，如果不在多边形里面，则返回-1
	 * @param p  
	 * @param point
	 * @return
	 */
	public static int indexOfPoly(Poly p,Point point) {
		for(int i =0;i<p.size();i++) {
			if((int)point.getX()==(int)p.points.get(i).getX()&&(int)point.getY()==(int)p.points.get(i).getY()) {
				return i;
			}
		}
	   return -1;
	}
}
