package testAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
//METHOD注解只能用在方法里面  元注解
@Target(value= {ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String studentName() default "";//必须加一个默认值
	int age() default 0;
	int id() default -1;
}
