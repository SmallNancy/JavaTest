package cn.nancy.Date01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy��MM��dd��hhʱ");
		Date d = new Date(123212123L);
		String str = df.format(d);//��ʱ�����ת�����ַ���
		System.out.println(str);
		System.out.println("############################");
		
		//�ַ���ת����ʱ�����,ע��ƥ������
		String str2 = "1997,7,7";
		DateFormat df2 = new SimpleDateFormat("yyyy,MM,dd");
		try {
			Date d2 = df2.parse(str2);
			System.out.println(d2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
