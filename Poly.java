package poly;

import java.util.List;

import java.util.ArrayList;

public class Poly  {
	List<Point> points = new ArrayList<Point>();
	List<Edge> edges = new ArrayList<Edge>();

	public List<Point> getPoints() {
		return points;
	}
	public void setPoints(List<Point> points) {
		this.points = points;
	}
	public List<Edge> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	public Poly(List<Point> points, List<Edge> edges) {
		this.points = points;
		this.edges = edges;
	}
	public Poly() {
	}
	public Poly(Poly p) {
		this.points = p.points;
		this.edges = p.edges;
	}
	public Poly(List<Point> points) {
		this.points = points;
		for(int i =0;i<points.size()-1;i++) {
			edges.add(new Edge(points.get(i), points.get(i+1)));
		}
		edges.add(new Edge(points.get(points.size()-1), points.get(0)));
	}
	
	public int size() {
		return points.size();
	}
	/**
	 * 多边形点打印
	 */
	public void printPoly() {
		for(int i = 0;i<size();i++) {
			System.out.println("第"+(i+1)+"个点的坐标为："+"("+points.get(i).getX()+"，"+points.get(i).getY()+")");
		}
	}
	/**
	 * 多边形边打印
	 */
	public void printEdge() {
		for(int i = 0;i<edges.size();i++) {
			System.out.println("第"+(i+1)+"条边为："+"("+edges.get(i).aPoint.getX()+"，"+edges.get(i).aPoint.getY()+")"+","+"("+edges.get(i).bPoint.getX()+"，"+edges.get(i).bPoint.getY()+")");
		}
	}
	/**
	 * 多边形所有点的FLAG标注打印
	 */
	public void printFlags() {
		for(int i=0;i<points.size();i++) {
			System.out.println("第"+(i+1)+"个点的EndFlag为："+points.get(i).isEndFlag+"     crossFlag为:"+points.get(i).isCrossPoint+"      ErgodicFlag为："+points.get(i).isErgodic+"      isInAnotherPolyFlag为："+points.get(i).isInAnotherPoly);
		}
	}
	/**
	 * 更新多边形的边集
	 */
	public void  updateEdges() {
		edges.clear();
		for(int i =0;i<points.size()-1;i++) {
			edges.add(new Edge(points.get(i), points.get(i+1)));
		}
		edges.add(new Edge(points.get(points.size()-1), points.get(0)));
	}
	/**
	 * 重设多边形内的所有点的标注，但是不重设多边形点的交点标志
	 */
	public void resetPointFlags() {
		for(int i = 0;i<this.size();i++) {
			this.points.get(i).resetPointsFlagsExceptCp();
		}
	}
}
