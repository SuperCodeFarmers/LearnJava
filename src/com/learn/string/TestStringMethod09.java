package com.learn.string;

import org.junit.jupiter.api.Test;

/*
 * 方法系列（9）：拆分
 * String[] split(String regex)
 * 
 */

public class TestStringMethod09 {

	@Test
	public void test04() {
		String str = "张三.23|李四.24|王五.25";
		// |在正则表达式有特殊意义，我们这里要把它当成普通的字符|，需要使用到转义字符
		String[] all = str.split("\\|");

		// 转成一个个学生对象
		Student[] students = new Student[all.length];
		for (int i = 0; i < students.length; i++) {
			// .在正则表达式有特殊意义，我这里想要表示普通的字符.，也要使用转义字符
			String[] strings = all[i].split("\\.");
			String name = strings[0];
			int age = Integer.valueOf(strings[1]);
			students[i] = new Student(name, age);
		}

		for (int i = 0; i < students.length; i++) {
			System.out.println(students[i]);
		}

	}

	@Test
	public void test02() {
		String str = "1Hello4321World512java234";
		str = str.replaceFirst("[0-9]+", "");
		String[] split = str.split("[0-9]+");
		System.out.println("split length:" + split.length);
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}
	}

	@Test
	public void test01() {
		String str = "hello a bds adf gaa asdfa";
		// 按照空格拆分
		String[] split = str.split(" ");
		for (int i = 0; i < split.length; i++) {
			System.out.println(split[i]);
		}

	}
}

class Student {
	private String nameString;
	private int age;

	public Student() {
		super();
	}

	public Student(String nameString, int age) {
		super();
		this.nameString = nameString;
		this.age = age;
	}

	/**
	 * @return the nameString
	 */
	public String getNameString() {
		return nameString;
	}

	/**
	 * @param nameString the nameString to set
	 */
	public void setNameString(String nameString) {
		this.nameString = nameString;
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

	@Override
	public String toString() {
		return "Student [nameString=" + nameString + ", age=" + age + "]";
	}

}
