package testFile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestReadFile {
	public static void main(String[] args) {
		
		FileReader reader = null;
		try {
			reader = new FileReader("D:/code/a.txt");

		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();//父类异常放后面处理
		}finally {
			//关闭资源
			try {
				if (reader!=null) {
					reader.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			String str;
			str = new TestReadFile().openFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	 String openFile() throws FileNotFoundException {
		// TODO Auto-generated method stub
		 FileReader reader1 = new FileReader("d:/code/a.txt");
		 return " ";
		 
	}
	
}
