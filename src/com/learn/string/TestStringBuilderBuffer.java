package com.learn.string;

import org.junit.jupiter.api.Test;

/*
 * 字符串的兄弟类
 * 
 * String：不可变对象。一旦修改就会有新对象。
 * 引入：可变字符序列，StringBuffer和StringBuilder
 * 
 * StringBuilder默认的char[]长度为16,
 * 	当容量不够了，扩容为原来的2倍+2
 * 
 * StringBuffer和StringBuilder
 * StringBuffer是线程安全的
 * StringBuilder是线程不安全的，JDK1.5引入
 * 
 * 方法：
 * （1）append(xx):拼接
 * （2）insert(int offset, xxx):在offset位置插入xxx
 * （3）delete(int start, int end):删除[start, end)位置的字符
 * （4）deleteCharAt(int index)：删除[index]位置
 * （5）reverse()：反转
 * （6）setCharAt(int index, char ch)：替换，把[index]位置的字符替换为ch
 * （7）setLength(int newLength)：指定长度
 * （8）substring(int start, int end):截取
 * （9）indexOf(String str)
 * （10）lastIndexOf(String str)
 * 
 */

public class TestStringBuilderBuffer {

	@Test
	public void test2() {
		StringBuilder s = new StringBuilder("helloworld");
		s.insert(5, "5");
		s.reverse();
		System.out.println(s);
		s.setLength(2);
		System.out.println(s);
		s.substring(0, 1);
	}

	@Test
	public void test1() {
		StringBuilder s = new StringBuilder();
		s.append("hello").append("true").append(false).append(1244);
		System.out.println(s);
		System.out.println(s.length());
		
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append("123123123");
		sBuffer.insert(0, false);
	}
}
