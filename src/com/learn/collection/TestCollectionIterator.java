package com.learn.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

/*
 * Collection系列的集合的便利：挨个访问集合的元素
 * （1）Object[] toArray()：先返回数组，然后遍历数组
 * （2）迭代器设计模式
 * 		每一个Collection系列的集合，内部都自带一个迭代器，类似于，每一趟公交车上都有自己的售票员
 * 
 * java.util.Iterator：接口
 * 	它是所有售票员的标准接口
 * 	（1）判断是否还有下一个元素：hasNext()
 * 	（2）访问它的下一个元素：next()
 * 	（3）删除下一个元素：remove()
 * 
 * 
 * java.util.Iterator：迭代器接口,这个接口的实现类在每一种集合类中，例如ArrayList内部有一个内部类实现了Iterator接口
 * 这里声明为内部类有两个原因：
 * （1）每一种集合的内部实现（物理结构不同），意味着对迭代器（售票员）的实现时不同的，每一种集合都要单独定制迭代器
 * （2）内部类可以直接访问外部类的私有的属性，成员，迭代器就可以直接访问集合的私有的元素
 * 
 * （3）foreach：增强for循环
 * 		foreach循环可以用于便利数组、Collection系列的集合等容器。
 * 		语法结构：
 * 		for(元素的类型 元素临时名称 : 元素和集合名) {    }
 * 
 * 
 * 什么样的集合或容器类型可以使用foreach循环？
 * 凡是实现了java.lang.Iterable可迭代接口的集合或容器都支持foreach循环
 * 
 * foreach底层还是调用Iterator迭代器来便利集合
 * 
 */

public class TestCollectionIterator {

	@Test
	public void test5() {
		MyArrayList c = new MyArrayList();
		c.add("张三");
		c.add("李四");
		c.add("王五");
		for (Object object : c) {
			System.out.println(object);
		}
	}

	@Test
	public void test4() {
		String[] arr = { "hello", "world", "java", "你好" };
		for (String str : arr) {
			System.out.println(str);
		}
	}

	@Test
	public void test3() {
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");

		// Object:元素的数据类型
		// obj:临时的元素名称
		// c:要遍历的集合的名称
		for (Object obj : c) {
			System.out.println(obj);
		}

	}

	@Test
	public void test2() {
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");

		// 返回这个集合自带的迭代器对象，相当于找到了售票员
		// 让售票员挨个访问元素
		Iterator<String> iterator = c.iterator();
		while (iterator.hasNext()) {
			String next = (String) iterator.next();
			// 要姓王的下车
			if (next.startsWith("王")) {
				iterator.remove();
			}
		}
		System.out.println(c);
	}

	@Test
	public void test1() {
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");

		// 返回这个集合自带的迭代器对象，相当于找到了售票员
		// 让售票员挨个访问元素
		Iterator iterator = c.iterator();
		while (iterator.hasNext()) {
			Object next = iterator.next();
			System.out.println(next);
		}
	}
}
