package cn.nancy.Date01;

import java.util.Date;

public class TestDate {
	public static void main(String[] args) {
		Date d = new Date();
		long t = System.currentTimeMillis();
		//java���Ժ�����
		System.out.println(t);
		Date d2 = new Date(1000); //1s==1000ms
		System.out.println(d2.toGMTString());//����б�ܴ�������ʹ��
		Date time = new Date(2018-8-12);
		
	}

}
