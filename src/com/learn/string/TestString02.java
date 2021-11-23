package com.learn.string;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

import org.junit.jupiter.api.Test;

/*
 * 字符串的比较
 * （1）==：比较对象的地址
 * 结论：只有两个字符串的常量对象比较是才会放回true，其他都是返回false
 * （2）equals：比较字符串的内容
 * 因为String类型重写了Object的equals
 * （3）equalsIgnoreCase(String anotherString)：比较字符串内容，不区分大小写
 * （4）大小比较
 * String类型实现了Comparable接口，重写了compareTo方法
 * 依次比较对应位置的字符
 * hello和Hello，先[0]位置的h和H，h>H,就直接认定hello>Hello
 * hello和hella，先[0][1][2][3]比较，最后到[4]o>a,认定hello>hella
 * hello和helloworld,发现前面都一样，长的大
 *
 * （5）大小比较：不区分大小写
 * String类型提供了一个方法compareToIgnoreCase(String str):可以胡罗大小写比较
 * 
 * （6）按照每个国家的语言校对顺序
 * java.text.Collator:Collator类执行区分语言环境的String比较。使用此类可为自然语言文本构造搜索和排序例程
 * 		Collator实现了Comparator接口
 * 		是抽象类，不能直接创建对象，他有一个直接子类RuleBaseCollator
 * 		Collator内部提供了一个静态方法，可以获取他的一个子类对象
 * 
 * 自然排序，实现java.lang.Comparable接口，int compareTo(object obj)
 * 定制排序
 */

public class TestString02 {
	@Test
	public void test11() {
		String[] arr = {"一", "二三四", "玉皇大帝"};
		// 希望按照拼音顺序排序，字典顺序
		Arrays.sort(arr, Collator.getInstance(Locale.CHINA));
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test10() {
		String[] arr = {"一", "二三四", "玉皇大帝"};
		Arrays.sort(arr); // 按照自然顺序，按照每一个字符的unicode编码值排序
		System.out.println(Arrays.toString(arr));
	}
	
	@SuppressWarnings("all")
	@Test
	public void test09() {
		String[] arr = { "hello", "chai", "Java", "Alice", "Hi" };
		// 排序
		// 按照字母的顺序排序，不区分大小写
		Arrays.sort(arr, new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				String s1 = (String) o1;
				String s2 = (String) o2;
				return s1.compareToIgnoreCase(s2);
			}
		}); // 按照元素的自然顺序排序
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test08() {
		String[] arr = { "hello", "chai", "Java", "Alice", "Hi" };
		// 排序
		// 按照字母的顺序排序
		Arrays.sort(arr); // 按照元素的自然顺序排序
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test07() {
		String s1 = new String("hello");
		String s2 = new String("Hello");

		if (s1.compareToIgnoreCase(s2) > 0) {
			System.out.println("s1 > s2");
		} else if (s1.compareToIgnoreCase(s2) < 0) {
			System.out.println("s1 < s2");
		} else {
			System.out.println("s1 = s2");
		}

	}

	@Test
	public void test06() {
		String s1 = new String("hello");
		String s2 = new String("Hello");
//		if (s2 > s2) {
//			
//		}

		if (s1.compareTo(s2) > 0) {
			System.out.println("s1 > s2");
		} else if (s1.compareTo(s2) < 0) {
			System.out.println("s1 < s2");
		} else {
			System.out.println("s1 = s2");
		}

	}

	@Test
	public void test05() {
		String s1 = new String("hello");
		String s2 = new String("hello");
		// 一个变量一个常量
		System.out.println(s1.equalsIgnoreCase(s2)); // true

		String s3 = "hello";
		System.out.println(s3.equalsIgnoreCase(s1)); // true

		String s4 = "Hello";
		System.out.println(s4.equalsIgnoreCase(s3)); // true
	}

	@Test
	public void test04() {
		String s1 = new String("hello");
		String s2 = new String("hello");
		// 一个变量一个常量
		System.out.println(s1.equals(s2)); // true

		String s3 = "hello";
		System.out.println(s3.equals(s1)); // true

		String s4 = "Hello";
		System.out.println(s4.equals(s3)); // false
	}

	@Test
	public void test03() {
		String s1 = new String("hello");
		String s2 = new String("hello");
		// 一个变量一个常量
		System.out.println(s1 == s2); // false
	}

	@Test
	public void test02() {
		String s1 = new String("hello");
		String s2 = "hello";
		// 一个变量一个常量
		System.out.println(s1 == s2); // false
	}

	@Test
	public void test01() {
		String s1 = "hello";
		String s2 = "hello";
		// 两个常量比较
		System.out.println(s1 == s2); // true
	}
}
