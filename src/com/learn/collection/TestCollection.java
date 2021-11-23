package com.learn.collection;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

/*
 * 数据结构，容器：
 * 	用来装对象......，等各种管理对象的容器
 * 
 * 
 * 容器有相同的操作标准：
 * （1）增
 * （2）删
 * （3）改
 * （4）查
 * ......
 * 
 * Java给这些集合抽取了两大接口：
 * 1、Collection：
 * 		规范单值集合的接口，obj --->单身的party
 * 2、Map
 * 		规范对值集合的接口，（key,value） ---->情侣party
 * 
 * 一、Collection
 * 1、Collection：
 * 	（1）它是根接口
 * 	（2）它没有直接的实现类，有更具体的子接口：List和Set......
 * 	（3）有一些的元素是可以重复的，有些元素是不能重复，有些集合的元素是有序的，有些集合的元素是无序的
 * 
 * 2、API
 * 	（1）添加
 * 		add(Object obj)：添加一个元素
 * 		addAll(Collection c)：添加多个元素
 * 	（2）获取有效元素的个数
 * 		int size()
 * 	（3）是否包含
 * 		contains(Object o)：判断o是否在当前的集合中
 * 		containsAll(Collection c)：判断c是否时当前集合的子集
 * 	（4）boolean isEmpty()：判断当前集合是否为空
 * 		等价于 集合对象.size() == 0
 * 	（5）remove(Object o)：删除一个
 * 		removeAll(Collection c)：删除多个，删除的时交集， this = this - this n c
 * 		clear()：清空所有
 * 	（6）retainAll(Collection c)：保留交集， this = this n c
 * 	（7）Object[] toArray()：把集合中的元素用一个数组返回
 * 
 */

public class TestCollection {
	@SuppressWarnings("all")
	@Test
	public void test9() {
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		Object[] array = c.toArray();
		System.out.println(array);
	}
	
	@SuppressWarnings("all")
	@Test
	public void test8() {
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		Collection c2 = new ArrayList(); 
		c2.add("张三");
		c2.add("射手");
		
		c.retainAll(c2);
		
		System.out.println(c);
	}
	
	@SuppressWarnings("all")
	@Test
	public void test7() {
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已
		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		Collection c2 = new ArrayList(); 
		c2.add("张三");
		c2.add("射手");
		
		c.removeAll(c2);
		
		System.out.println(c);
	}
	
	@SuppressWarnings("all")
	@Test
	public void test6() {
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已

		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		Collection c2 = new ArrayList(); 
		c2.add("张三");
		c2.add("李四");
		
		c.removeAll(c2);
		
		System.out.println(c);
	}
	
	@SuppressWarnings("all")
	@Test
	public void test5() {
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已

		c.add("张三");
		c.add("李四");
		c.add("王五");
		
		c.remove("李四"); // 删除一个
		System.out.println(c);
	}
	
	@SuppressWarnings("all")
	@Test
	public void test4() {
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已

		c.add("张三");
		c.add("李四");
		c.add("王五");
		System.out.println(c.contains("张三"));
		Collection c2 = new ArrayList(); 
		c2.add("张三");
		c2.add("李四");
		
		System.out.println(c.containsAll(c2)); // c2时c的子集
		
		Collection c3 = new ArrayList(); 
		c3.add("张三");
		c3.add("赵六");
		System.out.println(c.containsAll(c3)); // c3不是c的子集
	}

	@SuppressWarnings("all")
	@Test
	public void test3() {
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已

		c.add("张三");
		c.add("李四");
		c.add("王五");
		System.out.println(c.contains("张三"));
	}
	
	@SuppressWarnings("all")
	@Test
	public void test2() {
		/*
		 * 我这里左边写Collection，目的是只关注Collection 
		 * 因为多态引用时，c编译期间只能访问Collection的方法
		 */
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已

		c.add(1);
		c.add(2);
		c.add(3);
		
		Collection c2 = new ArrayList(); 
		c2.add("张三");
		c2.add("李四");
		c2.add("王五");
		
		c.addAll(c2); // 把c2中的所有元素都添加到c集合中
		System.out.println("获取有效元素的个数：" + c.size());
	}
	
	@SuppressWarnings("all")
	@Test
	public void test1() {
		/*
		 * 我这里左边写Collection，目的是只关注Collection
		 * 因为多态引用时，c编译期间只能访问Collection的方法
		 */
		Collection c = new ArrayList(); // ArrayList是Collection下面的实现类而已

		c.add("张三");
		c.add("李四");
		c.add("王五");

		System.out.println("获取有效元素的个数：" + c.size());
	}
}
