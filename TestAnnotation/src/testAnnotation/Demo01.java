package testAnnotation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo01 {
	
	//注解
	@Override
	public String toString() {
		return "";
	}
	
	//不建议使用,不鼓励使用
	@Deprecated
	public static void test00() {
		System.out.println("qqq");
	}
	
	
	//忽略警告
	@SuppressWarnings("all")
	private static void test002() {
		List list = new ArrayList();
	}
	public static void main(String[] args) {
		Date date = new Date();
		test00();
	}
}
