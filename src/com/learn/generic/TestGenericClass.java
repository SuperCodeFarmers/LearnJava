package com.learn.generic;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/*
 * 泛型的使用形式有2种
 * 1、泛型类\泛型接口
 * 2、泛型方法
 * 
 * 一、泛型类/接口
 * 1、语法格式：
 * 【修饰符】class 类名<泛型形参列表> {
 * }
 * 【修饰符】 interface 接口名<泛型形参列表> {
 * }
 * 
 * 例如：
 * public interface Collection<E>	<E>就是泛型形参列表
 * public class ArrayList<E> 		<E>就是泛型形参列表
 * public class HashMap<K,V>		<K,V>就是泛型形参列表
 * 我们看到在声明类或接口是，<E>,<K,V>,<U>...都是泛型的形参列表
 * 这些E,K,V,T等代表的是某种元素的类型
 * 
 * ArrayList<String> list = new ArrayList<String>();
 * 此时：<String>泛型的实参列表
 * 
 * //存储本组学员的姓名(key)和它的年龄(value)
 * HashMap<String,Integer> map = new HashMap<String,Integer>();
 *  此时：<String,Integer>是泛型的实参列表
 * 
 * 
 * 2、要求
 * 泛型实参必须是一个引用数据类型不能是基本数据类型
 * 
 * 3、如何为泛型类、泛型接口指定泛型实参
 * 	（1）创建泛型类的对象时
 * 		Student<String> chinese = new Strudent<String>("张三", "优秀");
 * 	（2）继承泛型类、泛型接口时可以指定泛型实参
 * 		class ChineseStudent extends Student<String>
 * 	（3）实现泛型接口是，可以指定泛型实参
 * 		class Employee implements Comparable<Employee>
 * 
 */

public class TestGenericClass {

	@Test
	public void test1() {
//		ArrayList<int> list = ArrayList<int>(); // 错误
		ArrayList<Integer> list = new ArrayList<Integer>();
	}
	
	@Test
	public void test2() {
		// 语文老师
		Student<String> stu = new Student<String>("张三", "优秀");
		
		// 数学老师
		Student<Double> math = new Student("李四", 88.7);
		
		// 英语老师
		Student<Character> englisth = new Student("王五", 'A');
	}
	
	@Test
	public void test3() {
		
	}
	
}

/*
 * 自定义一个泛型类 定义一个特殊的学生类，学生类包含两个属性：姓名，成绩 此时成绩很复杂： 语文老师在表示学生时：成绩登记为：优秀、良好、集合、不及格
 * 英语老师在表示学生是：成绩登记为：A、B、C、D.... 
 * 数学老师在表示学生时：
 * 成绩登记为：99、100、80、65....
 * 
 * <T>:泛型形参
 * T在这个Strudet中，当做就是score的类型，凡是需要表示score的类型的地方都用T
 * 
 */
class Student<T> {
	private String name;
	private T score;
	/**
	 * @param name
	 * @param score
	 */
	public Student(String name, T score) {
		super();
		this.name = name;
		this.score = score;
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
	/**
	 * @return the score
	 */
	public T getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(T score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
}

// 语文老师
class ChineseStudent extends Student<String> {

	/**
	 * @param name
	 * @param score
	 */
	public ChineseStudent(String name, String score) {
		super(name, score);
		// TODO Auto-generated constructor stub
	}
	
}

// 接口：java.lang.Comparable<T>
class Employee implements Comparable<Employee>{
	private int id;
	private String name;
	/**
	 * @param id
	 * @param name
	 */
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.id - o.id;
	}
	
	
	
}
