import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 简单错误记录
 * @author Small
 * 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
       2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
        3、 输入的文件可能带路径，记录文件名称不能带路径。
 */
public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> map = new HashMap<>();
		String key = "";
		while(sc.hasNext()) {
			String file = sc.next();
			int numLine = sc.nextInt();
			key = getName(file)+" "+numLine;
			if(map.containsKey(key)) {
				map.put(key, map.get(key)+1);
			}else {
				map.put(key, 1);
			}
			int count = 0;
			for(String s:map.keySet()) {
				count ++;
				if(count  > (map.keySet().size() -8 )) {
					System.out.println(map.keySet().size());
					System.out.println(s +" "+ map.get(key));
				}
			}
		}
		
	}
	
	//获取文件名
	public static String getName(String str) {
		String fileName = str.trim();
		if(fileName.contains("\\")) {
			fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
		}
		if(fileName.length()>16) {
			fileName = fileName.substring(fileName.length()-16, fileName.length());
		}
		
		return fileName;
	}

}
