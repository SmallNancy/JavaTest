package poly;
/**
 * 边类
 * @author Z.M.T
 *
 */
public class Edge {
	Point aPoint;//起始点
	Point bPoint;//结束点
	public Edge(Point aPoint, Point bPoint) {
		this.aPoint = aPoint;
		this.bPoint = bPoint;
	}
	public Point getaPoint() {
		return aPoint;
	}
	public void setaPoint(Point aPoint) {
		this.aPoint = aPoint;
	}
	public Point getbPoint() {
		return bPoint;
	}
	public void setbPoint(Point bPoint) {
		this.bPoint = bPoint;
	}
}
