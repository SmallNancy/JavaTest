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
	 * ����ε��ӡ
	 */
	public void printPoly() {
		for(int i = 0;i<size();i++) {
			System.out.println("��"+(i+1)+"���������Ϊ��"+"("+points.get(i).getX()+"��"+points.get(i).getY()+")");
		}
	}
	/**
	 * ����αߴ�ӡ
	 */
	public void printEdge() {
		for(int i = 0;i<edges.size();i++) {
			System.out.println("��"+(i+1)+"����Ϊ��"+"("+edges.get(i).aPoint.getX()+"��"+edges.get(i).aPoint.getY()+")"+","+"("+edges.get(i).bPoint.getX()+"��"+edges.get(i).bPoint.getY()+")");
		}
	}
	/**
	 * ��������е��FLAG��ע��ӡ
	 */
	public void printFlags() {
		for(int i=0;i<points.size();i++) {
			System.out.println("��"+(i+1)+"�����EndFlagΪ��"+points.get(i).isEndFlag+"     crossFlagΪ:"+points.get(i).isCrossPoint+"      ErgodicFlagΪ��"+points.get(i).isErgodic+"      isInAnotherPolyFlagΪ��"+points.get(i).isInAnotherPoly);
		}
	}
	/**
	 * ���¶���εı߼�
	 */
	public void  updateEdges() {
		edges.clear();
		for(int i =0;i<points.size()-1;i++) {
			edges.add(new Edge(points.get(i), points.get(i+1)));
		}
		edges.add(new Edge(points.get(points.size()-1), points.get(0)));
	}
	/**
	 * ���������ڵ����е�ı�ע�����ǲ��������ε�Ľ����־
	 */
	public void resetPointFlags() {
		for(int i = 0;i<this.size();i++) {
			this.points.get(i).resetPointsFlagsExceptCp();
		}
	}
}
