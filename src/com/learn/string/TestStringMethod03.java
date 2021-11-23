package com.learn.string;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

/*
 * 方法系列三：和byte相关，或者说和编码与解码相关
 * （1）byte[] getBytes():编码的方法，使用平台默认的字符编码进行编的
 * 		byte[] getBytes(编码方式)
 * 
 * 编码：对应ASCII码范围内（0~127）的，无论用什么编码方式，结果都是一样的，一个字符对应一个字节的编码
 * 		对于其他的字符，编码，结果不一定是几个字节，例如汉字
 * 		UTF-8：变成的，但是大多数汉字都是3个字节
 * 		GBK、GB2312:固定2个字节
 * 
 *  解码
 * （2）new String(字节数组， 编码方式)
 * 
 * 编码：
 * 	把字符---->字节的过程，编给计算机用的
 * 解码：
 *  把字节---->字符的过程，解给人看的
 *  
 *  乱码：
 *  （1）编码与解码字符集不一致
 */

public class TestStringMethod03 {

	public static String removeDuplicatedChars(String inStr) {
		// write code here
		StringBuffer sb = new StringBuffer();
		String str = inStr.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			// 依次拿出每一个字符
			char c = str.charAt(i);
			// 该字符的第一个索引位置和最后一个索引位置相同，表示只出现一次
			if (str.indexOf(c) == str.lastIndexOf(c)) {
				sb.append(c);
			} else {// 该字符的第一个索引位置和最后一个索引位置不同
				if (str.indexOf(c) == i) {
					sb.append(c);
				}
			}
		}
		String result = new String(sb);
		char[] charArray = result.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	@Test
	public void test05() {
		
	}

	@Test
	public void test04() throws UnsupportedEncodingException {
		String str = "于东洋";
		byte[] bytes = str.getBytes("gbk");
		System.out.println(Arrays.toString(bytes)); // [-45, -38, -74, -85, -47, -13]

		String str2 = new String(bytes, "gbk");
		System.out.println(str2);
	}

	@Test
	public void test03() {
		String str = "于东洋";
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes)); // [-28, -70, -114, -28, -72, -100, -26, -76, -117]
	}

	@Test
	public void test02() {
		String str = "abc";
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes)); // [97, 98, 99]
	}

	@Test
	public void test01() {
		String str = "a";
		byte[] bytes = str.getBytes();
		System.out.println(Arrays.toString(bytes)); // [97]
	}
}
