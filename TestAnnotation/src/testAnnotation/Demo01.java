package testAnnotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo01 {
	
	//ע��
	@Override
	public String toString() {
		return "";
	}
	
	//������ʹ��,������ʹ��
	@Deprecated
	public static void test00() {
		System.out.println("qqq");
	}
	
	
	//���Ծ���
	@SuppressWarnings("all")
	private static void test002() {
		List list = new ArrayList();
	}
	public static void main(String[] args) {
		Date date = new Date();
		test00();
	}
}
