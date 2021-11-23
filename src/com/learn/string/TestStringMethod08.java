package com.learn.string;

import org.junit.jupiter.api.Test;

/*
 * 方法系列（8）：替换
 * （1）String replace(CharSequence target, CharSequence replacement)
 * （2）String replaceAll(String regex, String replacement)
 * （3）String replaceFirst(String regex, String replacement)
 * 其中（2）和（3）支持正则
 */

public class TestStringMethod08 {
	@Test
	public void test04() {
		String str = "hello244world.java;8989";
		// 把其中的非字母去除掉
		str = str.replaceAll("[^a-zA-Z]", "");
		System.out.println(str);
	}

	@Test
	public void test03() {
		String str = "中国共产党是执政党，中国共产党是领导党";
		str = str.replaceAll("共产党", "***");
		System.out.println(str);
	}

	@Test
	public void test02() {
		String str = "中国共产党是执政党，中国共产党是领导党";
		str = str.replaceFirst("共产党", "***");
		System.out.println(str);
	}

	@Test
	public void test01() {
		String str = "中国共产党是执政党，中国共产党是领导党";
		str = str.replace("共产党", "***");
		System.out.println(str);
	}
}
