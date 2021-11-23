package com.learn.string;

import org.junit.jupiter.api.Test;

/*
 * java.lang.String
 * 1、特点
 * （1）String类型不能被继承，因为String是由final修饰
 * （2）String类型的对象是不可变
 * 换句话说，只要修改字符串，就会产生新对象
 * （3）String对象不可变的特性，使得我们可以把一些字符串存到常量池中，
 * 		字符串有常量池。常量池中的字符串是可以共享的
 * 
 * 字符串常量池在哪里？
 * （1）JDK1.6及以前：方法区
 * （2）JDK1.7：挪到堆中，及在队中单独划分了一块来存字符串常量
 * （3）JDK1.8:从堆中挪出，挪到一个“元空间meta space”，即类似于方法区
 * 
 * （4）String对象底层的存储
 * JDK1.9之前：底层使用char[]存储
 * JDK1.9之后：底层使用byte[]存储
 * 
 * （5）String对象怎么就不可变
 * 		1、底层char[]数组有final修饰，意味着这个数组不能扩容等，来达到存更多的字符
 * 		2、char[]数组是私有的，我们程序员无法直接操作这个char[]数组，而且String没有提供这样的方法
 * 			来修改char[]数组，String提供的所有方法，对数组的修改都是返回一个新的字符串对象。
 * 
 * 
 */
public class TestString01 {

	@Test
	public void test02() {
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1 == s2);
	}

	@Test
	public void test01() {
		String s1 = "hello";
		s1 = "world";

		s1 = s1 + "java";
	}
}
