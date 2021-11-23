package com.learn.string;

import org.junit.jupiter.api.Test;

/*
 * 方法系列（7）：匹配规则
 * boolean matches(String regex)
 * 
 * 正则表达式：用于检测文本的格式
 * 校验某个字符串是否符合xxx规则
 * 例如：电话号码
 * 		甚至可以校验是否是移动号
 * 		银行卡号
 * 		邮箱格式
 * 		.....
 * 
 */

public class TestStringMethod07 {

	@Test
	public void test02() {
		String str = "123456789";
		// 简单判断是否全部为数字
		boolean matches = str.matches("\\d+"); // 正则不是Java的语法，它是独立于Java的规则
		System.out.println(matches);
	}

	@Test
	public void test01() {
		String str = "123456789";
		// 判断它是否全部由数字组成，并且第一位不能是0，长度为9位
		// 第一位不能是0，[1-9]
		// 接下来8为的数字，那么[0-9]{8}+
		boolean matches = str.matches("[1-9][0-9]{8}+");
		System.out.println(matches);

	}
}
