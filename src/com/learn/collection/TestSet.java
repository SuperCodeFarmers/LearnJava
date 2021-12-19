package com.learn.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.TreeSet;

import org.junit.jupiter.api.Test;

/*
 * Collection是根接口，没有任何直接实现的。他有一些更具体的子接口，例如：List和Set
 * 
 * 一、Set接口
 * 1、Set系列的集合的元素是不能重复的。
 * 2、Set的实现类们：HshSet、TreeSet、LinkedHashSet
 * 		Set：如果按照元素的存储顺序来看，有一些是可以保证的，有一些是不能保证的。唯有LinkedHashSet可以保证元素添加的顺序
 * 			如果按照元素的大小顺序来说，有一些是可以保证的，有一些是不能保证的。唯有TreeSet可以保证元素的大小顺序
 * 		其中HashSet：既不能保证添加顺序，也不难保证大小顺序。是完全无序的。
 * 
 * 		List:有序的，可重复的
 * 				有序的解释：前后顺序，可能是[下标]索引顺序，也可以能是链表的next，prev的引用顺序
 * 3、Set接口没有增加方法，都是从Collection接口中继承的。
 * 
 * 4、HashSet和LinkedHashSet
 * 	HashSet：完全无序
 * 	LinkedHashSet：添加顺序
 * 	LinkedHashSet是HashSet的子类，比HashSet多维护了添加顺序。
 * 		当你既想要实现集合的不可重复性，有想要保证元素的添加顺序，就选择使用LinkedHashSet。否则就用List系列或HashSet。
 * 	LinkedHashSet干的事多了,效率低了。
 * 
 * 5、HashSet和TreeSet
 * 	HashSet：完全无序
 * 	TreeSet：大小顺序
 * 	当你需要元素不可重复，又要元素排大小时，就用TreeSet。
 * 
 * 要用到TreeSet，一定要用到java.lang.Comparable或java.util.Comparator
 * 
 * 6、如何保证元素不可重复的？
 * HashSet和LinkedHashSet的做法：
 * 		1、先比较hash值，如果hash值不一样，说明一定不相同，
 * 		2、如果哈希值一样，再调用equals方法比较
 * 
 * TreeSet：
 * 		按照元素的大小来决定元素是否相同
 * 
 */

@SuppressWarnings("all")
public class TestSet {

	@Test
	public void test10() {
		// 存储到TreeSet的元素不会用到它的hashCode和equals方法
		// TreeSet认为大小"相等"就是相同元素
		
		TreeSet set = new TreeSet(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;

				return 0;
			}

		});
		
		// 存储到TreeSet中的元素 不会 调用hashCode和equals方法
		Student s1 = new Student(12, "张三");
		Student s2 = new Student(142, "李四");
		Student s3 = new Student(1224, "王五");

		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println(set);
	}

	@Test
	public void test9() {
		HashSet set = new HashSet();
		
		// 存储到HashSet中的元素会调用hashCode和equals方法
		Student s1 = new Student(12, "张三");
		Student s2 = new Student(142, "李四");
		Student s3 = new Student(1224, "王五");
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println(s3.hashCode());

		set.add(s1);
		set.add(s2);
		set.add(s3);
		System.out.println(set);
	}

	@Test
	public void test8() {
		TreeSet set = new TreeSet(new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {
				Student s1 = (Student) o1;
				Student s2 = (Student) o2;

				return s1.getAge() - s2.getAge();
			}

		});
		// 这里因为Object类型没有实现了java.lang.Comparable接口，所有不可以添加到TreeSet
		set.add(new Student(12, "张三"));
		set.add(new Student(142, "李四"));
		set.add(new Student(1224, "王五"));
		System.out.println(set);
	}

	@Test
	public void test7() {
		TreeSet set = new TreeSet();
		// 这里因为Object类型没有实现了java.lang.Comparable接口，所有不可以添加到TreeSet
		set.add(new Object());
	}

	// 顺序:TreeSet是按照大小顺序的
	@Test
	public void test6() {
		TreeSet set = new TreeSet();
		// 这里因为String类型实现了java.lang.Comparable接口，所有可以添加到TreeSet
		set.add("张三");
		set.add("李四");
		set.add("王五");
		set.add("于东洋");
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		set.add("啊啊啊");
		System.out.println(set);

	}

	// 顺序:LinkedHashSet是按照添加顺序的
	@Test
	public void test5() {
		LinkedHashSet set = new LinkedHashSet();
		set.add("张三");
		set.add("李四");
		set.add("王五");
		set.add("于东洋");
		set.add("aaa");
		set.add("bbb");
		set.add("ccc");
		System.out.println(set);

	}

	// 顺序:HashSet是无序的
	@Test
	public void test4() {
		HashSet set = new HashSet();
		set.add("张三");
		set.add("李四");
		set.add("王五");
		set.add("于东洋");
		System.out.println(set);

	}

	// 不可重复
	@Test
	public void test3() {
		TreeSet set = new TreeSet();
		set.add("张三");
		set.add("张三");
		set.add("李四");
		System.out.println(set);

	}

	// 不可重复
	@Test
	public void test2() {
		LinkedHashSet set = new LinkedHashSet();
		set.add("张三");
		set.add("张三");
		set.add("李四");
		System.out.println(set);

	}

	// 不可重复
	@Test
	public void test1() {
		HashSet set = new HashSet();
		set.add("张三");
		set.add("张三");
		set.add("李四");
		System.out.println(set);

	}
}

class Student {
	private int age;
	private String name;

	/**
	 * @param age
	 * @param name
	 */
	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		System.out.println("Stundet的hashCode方法");
		return 11;
		// return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("Stundet的equals方法");

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

}