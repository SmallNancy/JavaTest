package poly;

public class Point {
		private final double x;  //x轴值，且不可修改
		private final double y;  //y轴值，且不可修改
		boolean isCrossPoint;   //点是否为交点
		boolean isEndFlag;  //点是否为递归结束标志点
		boolean isErgodic;	//点是否被遍历过
		boolean isInAnotherPoly;	//点是否在另一个多边形里面

		public  Point(double x,double y,boolean isCrossPoint) {
			this.x = x;
			this.y = y;
			this.isCrossPoint = isCrossPoint;
			this.isEndFlag=false;
			this.isErgodic=false;
		}
		public  Point(double x,double y) {
			this.x = x;
			this.y = y;
			this.isCrossPoint = false;
			this.isEndFlag=false;
			this.isErgodic=false;
			this.isInAnotherPoly=false;
		}
		public Point(Point p) {
			this.x=p.x;
			this.y=p.y;
			this.isCrossPoint=p.isCrossPoint;
			this.isEndFlag=p.isEndFlag;
			this.isErgodic=p.isErgodic;
			this.isInAnotherPoly=p.isInAnotherPoly;
		}
		/**
		 * 重设点的标志，但不重设点的交点标志
		 */
		public void resetPointsFlagsExceptCp() {
			this.isEndFlag=false;
			this.isErgodic=false;
			this.isInAnotherPoly=false;
		}
		public boolean isCrossPoint() {
			return isCrossPoint;
		}
		public void setCrossPoint(boolean isCrossPoint) {
			this.isCrossPoint = isCrossPoint;
		}
		public boolean isEndFlag() {
			return isEndFlag;
		}
		public void setEndFlag(boolean isEndFlag) {
			this.isEndFlag = isEndFlag;
		}
		public boolean isErgodic() {
			return isErgodic;
		}
		public void setErgodic(boolean isErgodic) {
			this.isErgodic = isErgodic;
		}
		public boolean isInAnotherPoly() {
			return isInAnotherPoly;
		}
		public void setInAnotherPoly(boolean isInAnotherPoly) {
			this.isInAnotherPoly = isInAnotherPoly;
		}
		public double getX() {
			return x;
		}
		public double getY() {
			return y;
		}

		
		
		
}
