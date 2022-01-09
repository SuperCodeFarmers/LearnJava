package com.learn.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

/*
 * 通配符：Wildcard
 * 通配符：？
 * 1、<?>：代表可以是任意类型
 * 2、<? extends 上限>：?代表是上限或上限的子类
 * 3、<? super 下限>：?代表的是下限或下限的父类
 * 
 * 看java.util.Collections:集合工具类
 * （1）public static boolean disjoint(Collection<?> c1, Collection<?> c2)
 * 		：看c1和c2是否有交集，如果没有交集返回true。这里就没有限定c1和c2是什么类型
 * 
 */

public class TestWildcard {
	
	@Test
	public void test05() {
		Collection<String> src = new ArrayList<String>;
		src.add("hello");
		src.add("world");
		Collection<Integer> dest = new ArrayList<Integer>();
		dest.add(1);
		dest.add(2);
		
//		copy(src, dest); // 把src中的"hello"、"world"添加到dest中，有问题
		
		Collection<Object> dest2 = new ArrayList<Object>();
		copy(src, dest2); // 把src中的"hello"、"world"添加到dest中，没有问题，此时T是String，`?`是Object
		
	}
	
	
	/*
	 * 举例：
	 * 想要声明一个方法，可以把一个Collection集合中src的元素，添加到另一个Collection集合dest中
	 * 如果要让dest接收src的所有元素，应该要对对象类型是有要求的
	 */
	public <T> void copy(Collection<T> src, Collection<? super T> dest) {
		for (Object object : src) {
			dest.add((T) object);
		}
	}
	
	
	@Test
	public void test04() {
		ArrayList<String> list = new ArrayList<String>();
//		printGraphic(list); // 错误，因为string不满足<? extends Graphic>
		
		ArrayList<Circle> list2 = new ArrayList<Circle>();
		printGraphic(list2); // 因为 Circle满足<? extends Graphic>
	}
	

	/*
	 * 举例： 想要声明一个方法，遍历一个里面装着图形对象的集合
	 */
	public void printGraphic(Collection<? extends Graphic> c) {
		for (Graphic obj : c) {
			System.out.println(obj);
		}
	}

	@Test
	public void test03() {
		Collection<String> c1 = new ArrayList<String>();
		c1.add("hello");

		Collection<Integer> c2 = new ArrayList<Integer>();
		c2.add(2);
		System.out.println(Collections.disjoint(c1, c2));

	}

	@Test
	public void test01() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4);
		print(list);
	}

	/*
	 * 声明一个方法：这个方法可以用于遍历所有的Collection系列的集合 此时因为Collection是一个泛型接口，Collection<E>
	 * 如果此时不指定<E>的具体类型，会报警告，（1）方式一，抑制警告。（2）方式二：用?来代表任意类型
	 */
	public void print(Collection<?> c) {
		for (Object object : c) {
			System.out.println(object);
		}
	}

	// 为什么不能使用Object代替`?`来用？
	// 以前我们说Object可以接收任意类型对象,但是不代表Collection<Object>可以接收任意泛型实参的集合
	// Collection<Object>这么写，只能接收Collection<Object>,List<Object>....，既泛型实参必须是<Object>
	/*
	 * public void print(Collection<Object> c) { for (Object object : c) {
	 * System.out.println(object); } }
	 */
	@Test
	public void test2() {
//		ArrayList<Object> list = new ArrayList<String>(); // 这是错误的，这不是多态
		String str = new String(); // 这是多态

	}
}

// 图形类
class Graphic {

}

// 圆类
class Circle extends Graphic {

}

//矩形类
class Rectangle extends Graphic {

}
