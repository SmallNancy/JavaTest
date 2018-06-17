package poly;

import java.util.List;

public class Util {
	/**
	 * �жϵ��Ƿ��ڶ��������
	 * @param poly �жϵĶ����
	 * @param pt �жϵĵ�
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
	 * ��Сֵ����
	 * @param a
	 * @param b
	 * @return
	 */
	public static double min(double a, double b){
	    if(a<b) return a;
	    else return b;
	}
	
	/**
	 * ���ֵ����
	 * @param a
	 * @param b
	 * @return
	 */
	public static double max(double a, double b){
	    if(a<b) return b;
	    else return a;
	}
	
	/**
	 * �ų�ʵ��
	 * @param p1 ��һ���ߵĵ�һ����
	 * @param p2 ��һ���ߵĵڶ�����
	 * @param q1 �ڶ����ߵĵ�һ����
	 * @param q2 �ڶ����ߵĵڶ�����
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
	 * �����ж�
	 * @param pFirst1 ��һ���ߵĵ�һ����
	 * @param pFirst2 ��һ���ߵĵڶ�����
	 * @param pSecond1 �ڶ����ߵĵ�һ����
	 * @param pSecond2 �ڶ����ߵĵڶ�����
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
	 * �ص��ж�
	 * @param p1 ��һ���ߵĵ�һ����
	 * @param p2 ��һ���ߵĵڶ�����
	 * @param q1 �ڶ����ߵĵ�һ����
	 * @param q2 �ڶ����ߵĵڶ�����
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
	 * ��ǰ���ж�
	 * @param a ��һ���ߵĵ�һ����
	 * @param b ��һ���ߵĵڶ�����
	 * @param c �ڶ����ߵĵ�һ����
	 * @param d �ڶ����ߵĵڶ�����
	 * @return
	 */
	public static boolean isHaveCrossPoint(final Point a,final Point b,final Point c,final Point d) {
		return IsRectCross(a, b, c, d)&&IsLineSegmentCross(a, b, c, d)&&(!IsOverlap(a, b, c, d));
	}
	
	 /**
	  * �󽻵㣬��ͨ���ų�ʵ�飬�����жϣ����Ҳ��ص�����ִ��
	  * @param p1 ��һ���ߵĵ�һ����
	  * @param p2 ��һ���ߵĵڶ�����
	  * @param q1 �ڶ����ߵĵ�һ����
	  * @param q2 �ڶ����ߵĵڶ�����
	  * @return
	  */
	public static Point GetCrossPoint(final Point p1,final Point p2,final Point q1,final Point q2)
	{

	    //�󽻵�
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
 * �����֮������ƽ��
 * @param p1 ��һ����
 * @param p2 �ڶ�����
 * @return
 */
	public static double Distance2(Point p1, Point p2){
	    return (p2.getY()-p1.getY())*(p2.getY()-p1.getY())+(p2.getX()-p1.getX())*(p2.getX()-p1.getX());
	}
	/**
	 * ������򣬽�һ���㼯�еĵ㰴������һ����ľ����Դ�С�����˳������
	 * @param aList �㼯
	 * @param p �жϵĵ�
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
	 * �ж��������Ƿ����
	 * @param apPoint ��һ����
	 * @param bpoint �ڶ�����
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
	 * �ҳ�ʼ����һ���������ĵ�
	 * @param aPoly ��һ�������
	 * @param bPoly  ��һ�������
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
	 * ���ҵ��ڶ���ε�������������ڶ�������棬�򷵻�-1
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
