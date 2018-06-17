package poly;

public class Point {
		private final double x;  //x��ֵ���Ҳ����޸�
		private final double y;  //y��ֵ���Ҳ����޸�
		boolean isCrossPoint;   //���Ƿ�Ϊ����
		boolean isEndFlag;  //���Ƿ�Ϊ�ݹ������־��
		boolean isErgodic;	//���Ƿ񱻱�����
		boolean isInAnotherPoly;	//���Ƿ�����һ�����������

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
		 * �����ı�־�����������Ľ����־
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
