package testFile;

import java.io.File;
import java.io.IOException;

public class TsetFile {
	public static void main(String[] args) {
		File file = new File("D:/code/abc.txt");
		File f1 = new File("D:/code");
		File f2 = new File(f1,"a.txt");
		
		try {
			f2.createNewFile();
			//����һ����Ŀ¼
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//��������Ŀ¼
		File f3 = new File("D:/code/aa/cc");
		f3.mkdirs();
		
		if (file.isFile()) {
			System.out.println("����һ���ļ�");
		}else {
			System.out.println("This is not a file.");
		}
		if (f1.isDirectory()) {
			System.out.println("����һ��Ŀ¼");
		}
	}

}
