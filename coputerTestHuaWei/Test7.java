import java.util.Scanner;
/**
 * ���7�й����ֵĸ���������7�ı��������а���7�����֣���17��27��37...70��71��72��73...��
 * �ĸ�����һ���������������ж������ݣ���ע�⴦��
 * @author Small
 *
 */
public class Test7 {
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	while(sc.hasNext()) {
	  int num = sc.nextInt();
	  int count = 0;
	  for(int i = 1;i<= num;i++) {
		  if((i % 7)==0) {
				count ++;
			}
	  }
	  for(int i = 10;i<=num;i++) {
		int temp = i;
		while(temp!=0) {
			if((temp%10==7)&&(temp %7!=0)) {
				count ++;
			}
			temp /= 10;
		}
		 
	  }
	  System.out.println(count);
    }
  }
}
