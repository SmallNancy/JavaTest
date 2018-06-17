package VisualCalendar;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * 可视化日历
 * @author nancy
 *
 */

public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("请输入日期：按照格式2013-01-23");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		//日期字符串转换成时间对象用DateFormat
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(str);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int day = calendar.get(Calendar.DATE);//获取日期
			calendar.set(Calendar.DATE,1);//日期置1

			//获取本月总天数
			int maxDate =calendar.getActualMaximum(Calendar.DATE);
			
			System.out.println("日\t一\t二\t三\t四\t五\t六\t");
			for(int i=1;i<calendar.get(Calendar.DAY_OF_WEEK);i++) {
				System.out.print("\t");
			}
			for(int i=1;i<=maxDate;i++) {
				if(i==day) {
					System.out.print("*");
				}
				System.out.print(i+"\t");
				int w =calendar.get(Calendar.DAY_OF_WEEK);
				
				if(w==Calendar.SATURDAY) {
					System.out.print('\n');
				}
				calendar.add(Calendar.DATE, 1);//天数+1
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
