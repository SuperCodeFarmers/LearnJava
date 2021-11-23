package com.learn.string;

import org.junit.jupiter.api.Test;

/*
 * 方法系列4
 * （1）boolean startsWith(String prefix)：判断是否以字符串prefix开头
 * （2）boolean endsWith(String suffix)：判断是否以字符串prefix结尾
 * 
 */

public class TestStringMethod04 {

	@Test
	public void test03() {
		String fileNameString = "Hello.class";
		if (fileNameString.endsWith(".java")) {
			System.out.println("Java的源文件");
		} else if (fileNameString.endsWith(".class")) {
			System.out.println("Java字节码文件");
		}
	}

	@Test
	public void test02() {
		String str = "加油学习！";
		System.out.println(str.startsWith("加油"));
	}

	@Test
	public void test01() {
		String nameString = "于东洋";
		if (nameString.startsWith("于")) {
			System.out.println("于家人");
		} else {
			System.out.println("不是于家人");
		}
	}
}
