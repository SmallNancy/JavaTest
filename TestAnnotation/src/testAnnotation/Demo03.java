package testAnnotation;

import java.lang.annotation.Annotation;
import java.lang.Class;

/**
 * 使用反射读取注解信息，模拟处理注解信息的流程
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
