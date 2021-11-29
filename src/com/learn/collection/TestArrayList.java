package com.learn.collection;

import java.util.ArrayList;

/*
 * ArrayList动态数组：源码跟踪
 * （1）new ArrayList():
 * 	JDK1.8版本：发现内部初始化为了一个长度为0的空数组 DEFAULTCAPACITY_EMPTY_ELEMENTDATA
 * 	JDK1.7版本：也是初始化为长度为0的空数组 EMPTY_ELEMENTDATA
 * 	JDK1.6版本：初始化为长度为10的数组
 * 
 * 
 * 为什么要初始化为空数组呢？
 * 因为在开发中，很多时候创建了ArrayList的对象,但是没有装元素,这个时候的话,如果初始化为10的数组,就浪费了空间。
 * 
 * （2）add(Object e)
 * 	JDK1.8：第一次添加元素，扩容为长度为10的数组
 * 	JDK1.8	如果不够了，再扩容为1.5倍
 * 
 * 
 */

public class TestArrayList {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(2);
	}
	
}
