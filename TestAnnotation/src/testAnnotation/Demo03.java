package testAnnotation;

import java.lang.annotation.Annotation;
import java.lang.Class;

/**
 * ʹ�÷����ȡע����Ϣ��ģ�⴦��ע����Ϣ������
 * @author nancy
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		try {
			Class<?> class1=Class.forName("testAnnotation.Student");
			Annotation[] annotations = class1.getAnnotations();
			for(Annotation a:annotations) {
				System.out.println(a);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
