package cn.nancy.testCalender;
/**
 * 测试日期类
 * @author nancy
 *
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

public class TestCalender {
	public static void main(String[] args) {
		Calendar c = new GregorianCalendar();
		
		//set\get方法
		//c.set(2001,Calendar.FEBRUARY,10,12,23,34);
		c.set(Calendar.YEAR, 2001);
		c.set(Calendar.MONTH, 2);
		
		Date d = c.getTime();
		System.out.println(d);
		System.out.println(c.get(Calendar.YEAR));
		
		//测试日期计算
		c.add(Calendar.MONTH, 1);
		System.out.println(c);
		c.add(Calendar.YEAR, -2);
		System.out.println(c);
	}
	

	
	

}
