package testFile;

import java.io.File;

public class FileTree {
	
	static void printFlie(File file,int level) {
		for(int i=0;i<level;i++) {
			System.out.print("-");
		}
		System.out.println(file.getName());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			
			//for(ѭ���������� ѭ���������� : Ҫ�������Ķ���)ѭ���� 
			for (File temp:files) {
				printFlie(temp, level+1);//�ݹ�
			}
		}
	}
	public static void main(String[] args) {
		File f = new File("D:/code/aa");
		printFlie(f, 0);
	}
}
