package testFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testException {
	public static void main(String[] args) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		computer c = null;
		c.start();
		//空指针异常 NullPointerException
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		
		
		//手动抛出异常
		 File file = new File("D:/code/a.txt");
			if (!file.exists()) {
				try {
					throw new FileNotFoundException("file is not find");
				}catch (FileNotFoundException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
			}

	}
	 class computer{
		 void start() {
			 System.out.println("start");
		 }
	 }
	
}
