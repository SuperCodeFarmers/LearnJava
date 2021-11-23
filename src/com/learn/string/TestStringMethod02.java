package com.learn.string;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

/*
 * 方法系列二：和char相关
 * （1）char[] toCharArray():把字符串转成字符数组
 * （2）char charAt(int index)
 * （3）String(char[] arr):构造器，用char数组进行构造
 * （4）String(char[] arr, int offset, int count):构造器，用插入数组进行构造，从数组的offset开始取count个字符
 */

public class TestStringMethod02 {

	@Test
	public void test04() {
		char[] arr = { 'h', 'e', 'l', 'l', 'o' };
		String str = new String(arr);
		String str2 = new String(arr, 0, 2);
		System.out.println(str);
		System.out.println(str2);
	}

	@Test
	public void test03() {
		String str = "HelloWorld";
		System.out.println(str.charAt(5));
	}

	@Test
	public void test02() {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入性别:");
		String str = input.next();
		char gender = str.charAt(0);
		System.out.println(gender);
	}

	@Test
	public void test01() {
		String str = "helLoworld";

		// 统计大写字母的个数
		char[] arr = str.toCharArray();
		int count = 0;
		for (int i = 0; i < arr.length; ++i) {
			if (arr[i] >= 'A' && arr[i] <= 'Z') {
				++count;
			}
		}
		System.out.println("大写字母的个数：" + count);
	}
}
