package testAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//METHODע��ֻ�����ڷ�������  Ԫע��
@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String studentName() default "";//�����һ��Ĭ��ֵ
	int age() default 0;
	int id() default -1;
}
