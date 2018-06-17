package cn.nancy.test;

public class Test01 {
	public static void main(String[] args) {
		Integer i = new Integer(1000);
		//能表示的最大数
		System.out.println(Integer.MAX_VALUE);
		//转换成16进制
		System.out.println(Integer.toHexString(i));
		
		Integer i2 = new Integer("123");
		Integer i3 = Integer.parseInt("234");
		System.out.println(i2.intValue());
		Integer a = 1000; //jdk5.0之后，自动装箱
		int c = new Integer(1500); // 自动拆箱,编译器改进:integer.intValue()
		
		Integer d = 1234;
		Integer d2 = 1234;
		System.out.println(d == d2);
		System.out.println(d.equals(d2));
		System.out.println("#########################");
		
		Integer d3 = 123;
		Integer d4 = 123;
		System.out.println(d3 == d4);
		System.out.println(d3.equals(d4));
		
		//[-128--127]之间的数，仍然当作基本数据类型
		
	}
}
