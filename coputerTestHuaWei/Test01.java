import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * �򵥴����¼
 * @author Small
 * 1�� ��¼���8�������¼��ѭ����¼������ͬ�Ĵ����¼�����ļ����ƺ��к���ȫƥ�䣩ֻ��¼һ��������������ӣ�
       2�� ����16���ַ����ļ����ƣ�ֻ��¼�ļ��������Ч16���ַ���
        3�� ������ļ����ܴ�·������¼�ļ����Ʋ��ܴ�·����
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
	
	//��ȡ�ļ���
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
