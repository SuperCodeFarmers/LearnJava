package com.learn.string;

import org.junit.jupiter.api.Test;

/*
 * 方法系列一：
 * （1）int length():返回字符串的长度，返回的是字符的个数
 * 因为String的内部(JDK1.9之前，即1.8)用char[]实现，这个长度就是value数组的长度
 * （2）boolean isEmpty():是否是空字符串
 * （3）String toLowerCase():把字母转成小写
 * 		String toUpperCase():把每个字母转成大写
 * （4）String trim():去除字符串的前后空白子符
 * （5）String concat():拼接，等价于'+'
 */

public class TestStringMethod01 {

	@Test
	public void test03() {
		String s1 = "hello";
		String s2 = "world";
		String s3 = s1 + s2; // 常量 + 常量 ===> 常量
		String s4 = s1.concat(s2);

		System.out.println(s3 == s4); // false
		System.out.println(s3.equals(s4)); // true
	}

	@Test
	public void test02() {
		String str = "    hello   world   ";
		String trim = str.trim(); // 所有对字符串的修改都是会返回新的字符串对象
		System.out.println("[" + trim + "]");
	}
}
