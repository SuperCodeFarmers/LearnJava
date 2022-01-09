package com.learn.generic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

/*
 * java.util.Collections 
 * （1）public static <T> boolean addAll(Collection<? super T> c, T... elements)
 * 		：把elements这些元素添加到c这个集合
 * （2）public static <T> int binarySearch(List<? extends Comparable<? super T>> list,T key)
 * 		：在list集合中找出key，用二分查找。此时要求list集合是有大小顺序的。
 * 			<? extends Comparable<? super T>>：list集合中的元素必须实现Comparable接口，`?`可以是T或T的父类,这个父类实现Comparable接口也可以
 * （3）public static <T> int binarySearch(List<? extends T> list,T key,Comparator<? super T> c)
 * 		：此时要求list集合是有大小顺序，按照你指定的Comparator对象进行比较大小
 * 			<? extends T>：是T或T的子类,说明list中存的元素是T类型或者T类型的子类对象
 * 			<? super T>:这个比较器是为了T或T的父类设计的比较器,也可以 
 *
 * 
 * 
 * 
 */

public class TestCollections {

	@Test
	public void test3() {
		ArrayList<Circle2> list = new ArrayList<Circle2>();
		list.add(new Circle2(2.2));
		list.add(new Circle2(3.5));
		list.add(new Circle2(5.0));

		Collections.binarySearch(list, new Circle2(2.2), new Comparator<Circle2>() {

			@Override
			public int compare(Circle2 o1, Circle2 o2) {
				if (o1.getArea() > o2.getArea()) {
					return 1;
				} else if (o1.getArea() < o2.getArea()) {
					return -1;
				}
				return 0;
			}

		});
	}

	@Test
	private void test2() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(123);
		list.add(3);
		list.add(23);

		// 此时T类型是Integer
		// list的<Integer>这个Integer实现了Comparable接口
		int index = Collections.binarySearch(list, 3);
	}

	@Test
	public void test1() {
		// 元素是1，2，3，4
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<String> list2 = new ArrayList<String>();
		ArrayList<Object> list3 = new ArrayList<Object>();
		ArrayList<Number> list4 = new ArrayList<Number>();

		// 此时T是Integer类型
		// <? supet T>:可以是Integer或它的父类
		Collections.addAll(list, 1, 2, 3, 4, 5);

		// 此时T是Integer类型
		// <? supet T>:可以是Integer或它的父类
//		Collections.addAll(list2, 1, 2, 3, 4, 5);

		// 此时T是Integer类型
		// Object满足<? supet T>
		Collections.addAll(list3, 1, 2, 3, 4, 5);

		// 此时T是Integer类型
		// Number满足<? supet T>
		Collections.addAll(list4, 1, 2, 3, 4, 5);

	}
}

abstract class Graphic2 {
	public abstract double getArea();
}

class Circle2 extends Graphic2 {
	private double radius;

	public Circle2(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
