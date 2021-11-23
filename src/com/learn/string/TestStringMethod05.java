package com.learn.string;

import org.junit.jupiter.api.Test;

/*
 * 方法系列5：和查找相关
 * （1）是否包含
 * boolean contains(CharSequence s)
 * （2） * int indexOf(String str)：查找字符串是否存在，如果存在则返回下标，不存在返回-1
 * （3）int lastIndexOf(String str):查找字符串是否存在，如果存在则返回最后一个的下标，不存在返回-1
 */

public class TestStringMethod05 {

	@Test
	public void test03() {
		String fileName = "Hello.java.txt";
		// 文件的后缀名是什么
		// 截取文件的后缀名
		// 1、第一步：找到最后一个.的位置
		int index = fileName.lastIndexOf('.');
		System.out.println(index);
	}

	@Test
	public void test02() {
		String str = "12345";
		int index = str.indexOf(".");
		System.out.println(index);
	}

	@Test
	public void test01() {
		String str = "123.45";
		if (str.contains(".")) {
			System.out.println("包含字符\".\"");
		}
	}
}
