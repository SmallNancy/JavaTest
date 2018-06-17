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
			
			//for(循环变量类型 循环变量名称 : 要被遍历的对象)循环体 
			for (File temp:files) {
				printFlie(temp, level+1);//递归
			}
		}
	}
	public static void main(String[] args) {
		File f = new File("D:/code/aa");
		printFlie(f, 0);
	}
}
