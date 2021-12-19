package com.learn.collection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

/*
 * 一、Map接口的实现类:
 * 1、HashMap
 * 2、HashTable
 * 3、TreeMap
 * 4、LinkedHashMap
 * 5、Properties
 * 
 * 二、HashMap和HashTable
 * HashTable：旧版。线程安全。它的key和value不能为null
 * HashMap:相对HashTable它来说新一点。线程不安全。它允许key和value为null值。
 * 
 * StringBuffer和StringBuilder
 * Vector和ArrayList
 * HashTable和HashMap
 * 
 * 三、HashMap和LinkedHashMap
 * LinkedHashMap是HasnMap的子类,比HashMap多维护了映射关系的添加顺序。
 * 
 * HashMap:无序的，
 * LinkedHashMap:可以记录添加顺序
 * 
 * LinkedHashMap比HashMap要做的事多，效率低。只在需要维护顺序时再使用它。
 * 
 * 四、HashMap和TreeMap
 * HashMap：无序的
 * TreeMap:按照key的大小顺序排列。
 * 
 * 五、Properties
 * Properties是HashTable的子类，不允许key和value为null，并且它的key和value类型都是string类型。
 * 通常用于存储配置属性
 * 而且为了可读性更好，还增加了两个方法
 * setProperty(String key, String value)
 * getProperty(String key)
 * 
 * 刘、所有的map的key不能重复?如何实现不重复
 * HashMap、HasmTable、LinkedHashMap、Property：依据key的hashCode和equals方法
 * TreeMap:依据key的大小,认为大小相等的两个key就是重复的
 * 
 * HashMap：如果key重复了，会用新的value覆盖原有的value。
 *
 * TreeMap要让key排大小,要么key类型实现了java.lang.Comparable接口，要么在创建TreeMap时,指定一个java.util.Compartor接口的实现类对象
 */

@SuppressWarnings("all")

public class TestMapImpl {

	
	// key不可重复
	@Test
	public void test07() {
		Map map = new HashMap();
		map.put("张三", "张三的值"); // 被覆盖
		map.put("李四", "李四的值");
		map.put("王五", "王五的值");
		map.put("赵六", "赵六的值");
		map.put("老七", "老七的值");
		map.put("张三", "张三的值2"); // 覆盖张三原有的值

		Set entrySet = map.entrySet();
		for (Object obj : entrySet) {
			System.out.println(obj);
		}
	}

	@Test
	public void test06() {
		Properties pro = System.getProperties(); // 获取系统配置属性
		Set entrySet = pro.entrySet();
		for (Object obj : entrySet) {
			System.out.println(obj);
		}
	}

	@Test
	public void test05() throws IOException {
		Properties pro = new Properties();
		pro.load(TestMapImpl.class.getClassLoader().getResourceAsStream("jdbc.properties"));
		String user = pro.getProperty("user");
		String pwd = pro.getProperty("pwd");
		System.out.println(user);
		System.out.println(pwd);
	}

	@Test
	public void test04() {
		Properties pro = new Properties();
		pro.setProperty("user", "admin");
		pro.setProperty("pwd", "123456");

		String user = pro.getProperty("user");
		String pwd = pro.getProperty("pwd");
		System.out.println(user);
		System.out.println(pwd);
	}

	@Test
	public void test03() {
		// 按照key的大小顺序
		Map map = new TreeMap();
		map.put("AA", "张三妻子");
		map.put("CA", "李四的妻子");
		map.put("BC", "王五的妻子");

		Set entrySet = map.entrySet();
		for (Object entry : entrySet) {
			System.out.println(entry);
		}
	}

	@Test
	public void test02() {
		// 按照添加顺序
		Map map = new LinkedHashMap();
		map.put("张三", "张三妻子");
		map.put("李四", "李四的妻子");
		map.put("王五", "王五的妻子");

		Set entrySet = map.entrySet();
		for (Object entry : entrySet) {
			System.out.println(entry);
		}

	}

	@Test
	public void test01() {
		// 完全无序
		Map map = new HashMap();
		map.put("张三", "张三妻子");
		map.put("李四", "李四的妻子");
		map.put("王五", "王五的妻子");

		Set entrySet = map.entrySet();
		for (Object entry : entrySet) {
			System.out.println(entry);
		}

	}

}
