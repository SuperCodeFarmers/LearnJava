package com.learn.DataStructure;

import org.junit.jupiter.api.Test;

/*
 * 数据结构：
 * 	逻辑结构：针对程序员使用角度来说
 * 	物理结构：针对程序员如何实现这个逻辑结构的底层结构
 * 
 * 1、动态数组
 * 	物理结构：数组
 * 	逻辑结构：动态数组
 * 		对于使用者来说，可以自动扩容，自己记录有效元素的个数.....
 * 
 */

public class TestMyArrayList {

	@Test
	public void test1() {
		// 1、创建一个容器对象
		MyArrayList list = new MyArrayList();

		// 2、往容器中装对象
		list.add(new Apple());
	}
}

class Apple {

}