import java.util.Scanner;
/**
 * 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）
 * 的个数（一组测试用例里可能有多组数据，请注意处理）
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
