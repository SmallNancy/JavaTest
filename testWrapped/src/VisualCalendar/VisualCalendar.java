package VisualCalendar;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 * ���ӻ�����
 * @author nancy
 *
 */

public class VisualCalendar {
	public static void main(String[] args) {
		System.out.println("���������ڣ����ո�ʽ2013-01-23");
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		//�����ַ���ת����ʱ�������DateFormat
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(str);
			Calendar calendar = new GregorianCalendar();
			calendar.setTime(date);
			int day = calendar.get(Calendar.DATE);//��ȡ����
			calendar.set(Calendar.DATE,1);//������1

			//��ȡ����������
			int maxDate =calendar.getActualMaximum(Calendar.DATE);
			
			System.out.println("��\tһ\t��\t��\t��\t��\t��\t");
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
				calendar.add(Calendar.DATE, 1);//����+1
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
