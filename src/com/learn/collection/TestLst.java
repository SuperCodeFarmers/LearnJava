package com.learn.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.jupiter.api.Test;

/*
 * Collection是根接口，没有提供任何直接实现的，他有一些更具体的子接口，例如：List和Set
 * 一、List:列表
 * 1、List系列的集合:有序的、可重复的
 * 2、List系列的集合：ArrayList(动态数组)、Vector（动态数组，向量类）、
 * 				LinkList（双向链表、双端队列、栈..）、Stack(栈)
 * 3、List的API
 * List接口比Collection接口多了一堆方法：
 * 下面列举的方法是比Collection接口多出来的，和它一样的就不一一列举了
 * （1）void add(int index, E element)：在[index]位置添加一个元素，相当于插入
 * 		boolean addAll(int index, Collection<? extends E> c)：在[index]添加多个元素
 * （2）Object remove(int index):删除指定位置的元素
 * （3）Object get(int index):获取，返回[index]位置的元素
 * （4）Object set(int index, Object element):替换[index]位置的元素为element
 * （5）int indexOf(object o):在当前集合中查找o这个元素的下标，如果没有返回-1，如果有就返回找到的第一个元素的下标
 * （6）int lastIndexOf(Object o):  在当前集合中查找o这个元素的下标，如果没有返回-1，如果有就返回找到的最后一个的下标
 * （7）List subList(int fromIndex, int toIndex):截取一部分，[fromIndex, toIndex)
 * （8）ListIterator<E> listIterator()：获取一种迭代器
 * 		listIterator是Iterator的子接口，它比Iterator增加了:从后遍历的方法，增加了遍历的同时添加和修改。
 * 
 * Iterator:
 * （1）boolen hasNext()
 * （2）object next()
 * （3）void remove()
 * 
 * ListIterator：多出来的方法
 * （1）boolean hasPrevious()：如果以逆向遍历列表，判断前面是否还有元素
 * （2）E previous()：获取前面的元素
 * （3）void add(E e)：遍历的同时，添加元素
 * （4）void set(E e)：遍历的同时，替换元素
 * （5）int nextIndex()：返回下一个元素的索引
 * （6）int previousIndex()：返回前一个元素的索引
 * 
 * 
 * 说明：虽然List系列的集合都是可以通过索引/下标进行操作的，但是像LinkedList这类集合,其实不建议使用和索引相关的方法进行操作。
 * 因为他们的底层的物理结构不是数组，如果通过索引操作，会需要从头部或尾部找到对应的索引，效率不高。
 */

public class TestLst {
	
	@SuppressWarnings("all")
	@Test
	public void test8() {
		// 左边使用List多态引用的目的是为了关注List接口方法
		List list = new ArrayList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		//[1,2,3,4,5,6]
		ListIterator iter = list.listIterator(1); // 把游标指向任意有效位置
		while (iter.hasPrevious()) {
			Object next = iter.previous();
			System.out.println(next);
		}
		
		 iter = list.listIterator(0);
		 System.out.println(iter.next());
	}
	
	@SuppressWarnings("all")
	@Test
	public void test7() {
		// 左边使用List多态引用的目的是为了关注List接口方法
		List list = new ArrayList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

//		ListIterator iter = list.listIterator();// 默认的游标在开头
		ListIterator iter = list.listIterator(list.size()); // 把游标指向最后
		while (iter.hasPrevious()) {
			Object next = iter.previous();
			System.out.println(next);
		}
	}

	@SuppressWarnings("all")
	@Test
	public void test6() {
		// 左边使用List多态引用的目的是为了关注List接口方法
		List list = new ArrayList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);

		ListIterator iter = list.listIterator();
		while (iter.hasNext()) {
			Object next = iter.next();
			System.out.println(next);
		}
		System.out.println("----------------------------------------");
		while (iter.hasPrevious()) {
			Object next = iter.previous();
			System.out.println(next);
		}

	}

	@SuppressWarnings("all")
	@Test
	public void test5() {
		// 左边使用List多态引用的目的是为了关注List接口方法
		List list = new ArrayList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		list.set(3, 199);

		System.out.println(list);

		Object obj = list.get(2);
		System.out.println(obj);
	}

	@SuppressWarnings("all")
	@Test
	public void test4() {
		// 左边使用List多态引用的目的是为了关注List接口方法
		List list = new ArrayList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);

		for (Object object : list) {
			System.out.println(object + ":" + object.getClass());
		}

		System.out.println(list);
	}

	@SuppressWarnings("all")
	@Test
	public void test3() {
		// 左边使用List多态引用的目的是为了关注List接口方法
		List list = new ArrayList();

		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println(list);

		/*
		 * 这里remove(1)它调用的是remove(int index)这个方法。 为什么不是调用remove(Oject obj)？
		 * 因为1是基本数据类型，和int最匹配。集合装进入的是对象，并不是基本数据类型。
		 */

		// 这里remove中传入的1是索引，如果传入的是包装类Integer对象1则会删除list中元素1
		// list.remove(1);
		list.remove(new Integer(1)); // 删除的是对象
		System.out.println(list);
	}

	@SuppressWarnings("all")
	@Test
	public void test2() {
		// 左边使用List多态引用的目的是为了关注List接口方法
		List list = new ArrayList();

		list.add("张三");
		list.add(0, "李四");
		list.remove(1);
		System.out.println(list);
	}

	@SuppressWarnings("all")
	@Test
	public void test1() {
		// 左边使用List多态引用的目的是为了关注List接口方法
		List list = new ArrayList();

		list.add("张三");
		list.add(0, "李四");
		System.out.println(list);
	}
}
