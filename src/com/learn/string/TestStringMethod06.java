package com.learn.string;

import org.junit.jupiter.api.Test;

/*
 * 方法系列（6）：截取
 * （1）String substring(int beginIndex)：从字符串的[beginIndex]截取到最后
 * （2）String substring(int beginIndex, int endIndex)：截取字符串的[beginIndex, endIndex)部分
 */

public class TestStringMethod06 {

	@Test
	public void test04() {
		String str = "helloworldjava";
		String substring = str.substring(2, 6);
		System.out.println(substring);
	}
	
	@Test
	public void test03() {
		String fileName = "Hello.java.txt";
		// 文件的后缀名是什么
		// 截取文件的后缀名
		// 1、第一步：找到最后一个.的位置
		int index = fileName.lastIndexOf('.');
		System.out.println(index);

		// 2、第二部：截取
		String substring = fileName.substring(index);
		System.out.println(substring);
	}
}
