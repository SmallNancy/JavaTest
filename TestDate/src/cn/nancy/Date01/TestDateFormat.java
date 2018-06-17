package cn.nancy.Date01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("yyyy年MM月dd日hh时");
		Date d = new Date(123212123L);
		String str = df.format(d);//将时间对象转换成字符串
		System.out.println(str);
		System.out.println("############################");
		
		//字符串转换成时间对象,注意匹配问题
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
