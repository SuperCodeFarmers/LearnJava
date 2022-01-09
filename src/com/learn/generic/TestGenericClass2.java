package com.learn.generic;

import java.io.Serializable;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/*
 * 补充：
 * 4、泛型类或泛型接口上的<泛型类型>这个类型可以用在那些地方？
 * （1）可以用于属性、方法的数据形参、局部变量等的类型
 * （2）不能用于静态成员上，包括静态方法、静态属性
 * 
 * 5、泛型类或泛型接口的泛型形参，可以设定上限
 * <T extends 上限>
 * 	T的类型实参只能是上限本身或上限的子类
 * 
 * <T extends 上限1 & 上限2 & 上限3....>
 * 如果多个上限，都要满足
 * 
 * 
 * 6、泛型的形参一般代表什么的类型？
 * ArrayList<E>:这个E代表集合的元素的类型
 * Map<K,V>:这个K代表key的类型，V代表的value类型
 * Comparable<T>:这个T代表,要与当前对象比较的另一个对象的类型
 * Student<T>:这个T代表成绩的类型
 * 
 * 7、如果在使用泛型类或泛型接口的时候，如果没有指定泛型实参，会怎么样？
 * 泛型被擦除，泛型倍擦除后，泛型形参被解析为什么类型呢？
 * 被解析为泛型形参的第一个上限的类型。
 * (1)如果没有指定泛型形参的上限，就按Object处理.
 * (2)如果指定泛型形参的上限，就按照上限处理，如果有多个上限，多个上限用&连接，按照最左边第一个处理
 * 
 * 6、泛型类或泛型接口的泛型形参，可以设定下限
 * 
 */

public class TestGenericClass2 {

	@Test
	public void test02() {
		ArrayList list =new ArrayList();
		list.add("123"); // 泛型擦除，按照Object处理
		
		XueSheng x = new XueSheng("123", 80); // XueSheng(String, Number)
	}

	@Test
	public void test01() {
//		XueSheng<String> x = new XueSheng("张三", "优秀"); // 错误的，因为String不是Number或Number的子类
		XueSheng<Double> x = new XueSheng<Double>("张三", 66.6);
		XueSheng<Integer> x2 = new XueSheng<Integer>("张三", (int) 66.6);
		XueSheng<Long> x3 = new XueSheng<Long>("张三", (long) 66.6);
	}

}


// 泛型有多个上限
// T的类型实参要求，同时是Number的子类,还要实现Comparable和Serializable接口
class AClass<T extends Number & Comparable & Serializable> {
	
}



/*
 * 自定义一个泛型类 定义一个特殊的学生类，学生类包含两个属性：姓名，成绩 此时成绩很复杂：
 * 英语老师在表示学生是：成绩登记为：90.5、100.0、58.5、65.5.... 数学老师在表示学生时：成绩登记为：99、100、80、65....
 * 
 * <T>:泛型形参 T在这个Strudet中，当做就是score的类型，凡是需要表示score的类型的地方都用T
 * 
 * 此时想要限定这个T必须是一个数字,不能是字符串等其他类型
 * 
 */
class XueSheng<T extends Number> {
	private String name;
	private T score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getScore() {
		return score;
	}

	public void setScore(T score) {
		this.score = score;
	}

	public XueSheng(String name, T score) {
		super();
		this.name = name;
		this.score = score;
	}

}

class MyClass<T> {
	private T t; // 用于当做属性的数据类型
//	private static T t2; // 泛型不能用于静态属性上，因为调用静态对象时，不需要new具体的对象这样就没法传入具体的类型，就无法使用

	public MyClass(T t) { // 用于当做方法的数据形参的类型
		super();
		this.t = t;
	}

	// 可以用于返回值的类型
	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}