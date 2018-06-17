package testAnnotation;


//属性信息注解
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Field {
	String columnName();
	String type();
	int lengh();

}
