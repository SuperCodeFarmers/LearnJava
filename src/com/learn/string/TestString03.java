package com.learn.string;

import org.junit.jupiter.api.Test;

/*
 * 1、面试题
 * （1）String str = new String("hello");有几个对象，两个
 * （2）String str1 = new String("hello"); 有几个对象，三个
 * 		String str2 = new String("hello");
 * 
 * 2、拼接的结果在堆还是在常量池
 * 因为只有常量池中才是共享的，==比较才为true
 * （1）常量+常量在常量池
 * （2）变量+常量在堆中
 * （3）变量+变量在堆中
 * （4）xx.intern()，在常量池
 * 
 * 3、空字符串
 * （1）""
 * （2）new String()
 * （3）new String("")
 * 
 * 四种方式:
 * (1):if (str != null && str.equals(""))
 * (2):if (str != null && str.isEmpty())
 * (3):"".equals(str); // 推荐
 * 
 */

public class TestString03 {

	@Test
	public void test08() {
		String str = null;
		System.out.println(strIsEmpty(str));
	}

	// 判断str是否是空字符串，是就返回true，不是返回false
	public boolean strIsEmpty(String str) {
		// 当常量与非常量比较时，把常量放到前面
		// 这是代码简洁和优化的方案
		return "".equals(str); // 推荐
	}

	/*
	 * public boolean strIsEmpty(String str) { if (str != null && str.equals("")) {
	 * return true; } return false; }
	 */

	@Test
	public void test07() {
		// 空字符串
		String s1; // 变量未初始化
		String s2 = null; // 初始化为null
		String s3 = ""; // 空字符串常量对象
		String s4 = new String(); // 空字符串对象
		String s5 = new String(""); // 两个对象，一个是常量池中的，一个是堆中的

//		System.out.println(s1); // 无法使用
//		System.out.println(s2.length()); // 空指针异常

		System.out.println(s3.length());
	}

	@Test
	public void test06() {
		String s1 = "hello";
		String s2 = "world";
		String s3 = "helloworld";

		String s4 = (s1 + "world").intern(); // 把拼接的结果放到常量池中
		String s5 = (s1 + s2).intern();

		System.out.println(s3 == s4); // true
		System.out.println(s3 == s5); // true
	}

	@Test
	public void test05() {
		final String s1 = "hello";
		final String s2 = "world";
		String s3 = "helloworld";

		String s4 = s1 + "world"; // s4字符串内容也是helloworld，s1是常量，"world"是常量，常量 + 常量的结果在堆中
		String s5 = s1 + s2; // s5字符串内容也是helloworld，s1和s2都是常量，常量+常量的结果在堆中

		String s6 = "hello" + "world"; // 常量+常量结果在常量池中，因为编译期间就可以确定结果

		System.out.println(s3 == s4); // true
		System.out.println(s3 == s5); // true
		System.out.println(s3 == s6); // true
	}

	@Test
	public void test04() {
		String s1 = "hello";
		String s2 = "world";
		String s3 = "helloworld";

		String s4 = s1 + "world"; // s4字符串内容也是helloworld，s1是变量，"world"是常量，变量 + 常量的结果在堆中
		String s5 = s1 + s2; // s5字符串内容也是helloworld，s1和s2都是变量，变量+变量的结果在堆中

		String s6 = "hello" + "world"; // 常量+常量结果在常量池中，因为编译期间就可以确定结果

		System.out.println(s3 == s4); // false
		System.out.println(s3 == s5); // false
		System.out.println(s3 == s6); // true
	}

	@Test
	public void test03() {
		String str1 = new String("hello");
		String str2 = new String("hello");
		// 三个对象
		// 一个在常量池中:hello
		// 另两个在堆中，String的对象
		// 堆中的这两个字符串对象char[]的value数组，指向常量池中“hello”的char[]的value
	}

	@Test
	public void test02() {
		String str = new String("hello"); // 两个字符串对象
		// 一个在常量池中:hello
		// 另一个在堆中，String的对象
		// 堆中的这个字符串对象char[]的value数组，指向常量池中“hello”的char[]的value
	}

	@Test
	public void test01() {
		String str = "hello"; // 一个字符串对象
	}
}
